package com.steveq.scrabblehacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class InputLettersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_letters);
    }

    public void findWords(View view){
        Intent intent = new Intent(this, PresentingResultActivity.class);
        startActivity(intent);
    }
}
