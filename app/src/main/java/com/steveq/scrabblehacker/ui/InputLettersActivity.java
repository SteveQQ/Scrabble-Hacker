package com.steveq.scrabblehacker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.steveq.scrabblehacker.R;
import com.steveq.scrabblehacker.model.Generator;
import com.steveq.scrabblehacker.model.WordsFinder;

import java.util.ArrayList;


public class InputLettersActivity extends AppCompatActivity {
    private EditText mInputArea;
    private Button mFindButton;
    private WordsFinder mWordsFinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_letters);

        mInputArea = (EditText)findViewById(R.id.inputArea);
        mFindButton = (Button)findViewById(R.id.findButton);
        mWordsFinder = new WordsFinder(this);


        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mInputArea.getText().toString();
                if(!input.equals("")) {
                    mWordsFinder.searchForWords(input);
                    Intent intent = new Intent(InputLettersActivity.this, PresentingResultActivity.class);
                    intent.putExtra("words", mWordsFinder.getAnagrams().getRealWords());
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(InputLettersActivity.this, R.string.errorToast, Toast.LENGTH_LONG );
                    toast.show();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mInputArea.setText("");
        mWordsFinder.getAnagrams().clearWordsList();
        mWordsFinder.getAnagrams().setRealWords();
        mWordsFinder.getAnagrams().clearAnagramsList();
    }
}
