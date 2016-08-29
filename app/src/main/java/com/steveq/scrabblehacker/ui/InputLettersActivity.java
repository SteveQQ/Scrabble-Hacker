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
    private String input;
    private Generator mGenerator;
    ArrayList<String> anagrams;
    WordsFinder wordsFinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_letters);

        mInputArea = (EditText)findViewById(R.id.inputArea);
        mFindButton = (Button)findViewById(R.id.findButton);
        wordsFinder = new WordsFinder(InputLettersActivity.this);
        anagrams = new ArrayList<>();

        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = mInputArea.getText().toString();
                mGenerator = new Generator(input);
                if(!input.equals("")) {
                    Intent intent = new Intent(InputLettersActivity.this, PresentingResultActivity.class);
                    anagrams = mGenerator.generateAnagrams(input);
                    intent.putStringArrayListExtra("anagrams", anagrams);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(InputLettersActivity.this, R.string.errorToast, Toast.LENGTH_LONG );
                    toast.show();
                }
                /*if(!input.equals("")) {
                    Intent intent = new Intent(InputLettersActivity.this, PresentingResultActivity.class);
                    wordsFinder.searchForWords(input);
                    intent.putStringArrayListExtra("words", wordsFinder.getWordsList());
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(InputLettersActivity.this, R.string.errorToast, Toast.LENGTH_LONG );
                    toast.show();
                }*/
            }
        });
    }

}
