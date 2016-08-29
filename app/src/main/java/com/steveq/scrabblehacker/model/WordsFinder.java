package com.steveq.scrabblehacker.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class WordsFinder {

    private Context mContext;
    private Resources mResources;
    private Set<String> mDictWordsList;
    private ArrayList<String> mWordsList;
    private Generator mGenerator;

    public WordsFinder(Context ctx){
        mContext = ctx;
        mDictWordsList = new HashSet<>();
        mGenerator = new Generator("");
    }

    public ArrayList<String> getWordsList() {
        return mWordsList;
    }

    public void setWordsList(ArrayList<String> wordsList) {
        mWordsList = wordsList;
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

    public void searchForWords(String input){
        ArrayList<String> anagrams = mGenerator.generateAnagrams(input);
        readFile();
        for (String anagram : anagrams){
            if(mDictWordsList.contains(anagram)){
                mWordsList.add(anagram);
            }
        }
    }
}
