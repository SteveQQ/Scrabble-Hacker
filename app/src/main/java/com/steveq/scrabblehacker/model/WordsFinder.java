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

    private Generator mGenerator;
    private Anagrams mAnagrams;
    private Set<String> mDictWordsList;

    public WordsFinder(Context ctx){
        mDictWordsList = new HashSet<>();
        mAnagrams = new Anagrams();
        mGenerator = new Generator(mAnagrams);
        readFile(ctx);
    }

    public Anagrams getAnagrams() {
        return mAnagrams;
    }

    public void readFile(Context ctx){
        Resources resources = ctx.getResources();
        InputStream is = resources.openRawResource(resources.getIdentifier("slowa", "raw", ctx.getPackageName()));
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader reader = new BufferedReader(isr);
        String line;
        try{
            while((line = reader.readLine()) != null){
                mDictWordsList.add(line);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void searchForWords(String input){
        String word = input;
        mAnagrams.setOriginWord(input);
        /*while(input.length() >= 2){

            input = input.substring(0, input.length()-1);
        }*/
        mAnagrams.addAnagramsList(mGenerator.generateAnagrams(input));
        ArrayList<String> metaList = new ArrayList<>();
        for (String anagram : mAnagrams.getAnagramsList()) {
            if (mDictWordsList.contains(anagram)) {
                metaList.add(anagram);
            }
        }
        mAnagrams.setRealWordsList(metaList);
        mAnagrams.setRealWords();
    }
}
