package com.steveq.scrabblehacker.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.steveq.scrabblehacker.InputLettersActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class WordsFinder {

    private Context mContext;
    private Resources mResources;
    private Set<String> mDictWordsList;

    public WordsFinder(Context ctx){
        mContext = ctx;
        mDictWordsList = new HashSet<>();
    }

    public void readFile(){
        mResources = mContext.getResources();
        InputStream is = mResources.openRawResource(mResources.getIdentifier("slowa", "raw", mContext.getPackageName()));
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String line;

        try{
            while((line = reader.readLine()) != null){
                mDictWordsList.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            Log.d("SIZE", mDictWordsList.size() + "");
        }
    }
}
