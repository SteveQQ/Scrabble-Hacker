package com.steveq.scrabblehacker.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.steveq.scrabblehacker.R;

import java.util.ArrayList;

public class PresentingResultActivity extends AppCompatActivity {

    private TextView mResults;
    private Button mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenting_result);

        mResults = (TextView)findViewById(R.id.resultArea);
        mBackButton = (Button)findViewById(R.id.backButton);

        mResults.setMovementMethod(new ScrollingMovementMethod());

        Intent receivedIntent = getIntent();
        ArrayList<String> anagrams = receivedIntent.getStringArrayListExtra("anagrams");
        StringBuilder stringBuilder = new StringBuilder();
        for(String anagram : anagrams){
            stringBuilder.append(anagram + "\n");
        }
        mResults.setText(stringBuilder);

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PresentingResultActivity.this, InputLettersActivity.class);
                startActivity(intent);
            }
        });
    }

}
