package com.steveq.scrabblehacker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class PresentingResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_presenting_result);
    }

    public void backToInput(View view){
        Intent intent = new Intent(this, InputLettersActivity.class);
        startActivity(intent);
    }
}
