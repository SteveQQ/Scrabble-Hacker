package com.steveq.scrabblehacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


public class InputLettersActivity extends AppCompatActivity {
    private EditText mInputArea;
    private Button mFindButton;
    private String input;
    private Generator generator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_letters);

        mInputArea = (EditText)findViewById(R.id.inputArea);
        mFindButton = (Button)findViewById(R.id.findButton);
        generator = new Generator();

        mFindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = mInputArea.getText().toString();
                if(!input.equals("")) {
                    Intent intent = new Intent(InputLettersActivity.this, PresentingResultActivity.class);
                    generator.setInputWord(input);
                    ArrayList<String> anagrams = generator.generateAnagrams(input);
                    intent.putStringArrayListExtra("anagrams", anagrams);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(InputLettersActivity.this, R.string.errorToast, Toast.LENGTH_LONG );
                    toast.show();
                }
            }
        });
    }

}
