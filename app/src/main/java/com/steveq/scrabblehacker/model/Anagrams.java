package com.steveq.scrabblehacker.model;

import java.util.ArrayList;

public class Anagrams {
    private String mOriginWord;
    private ArrayList<String> mAnagramsList;

    public Anagrams(String originWord){
        mAnagramsList = new ArrayList<>();
        mOriginWord = originWord;
    }

    public String getOriginWord() {
        return mOriginWord;
    }

    public void setOriginWord(String originWord) {
        this.mOriginWord = originWord;
    }

    public ArrayList<String> getAnagramsList() {
        return mAnagramsList;
    }

    public void setAnagramsList(ArrayList<String> anagramsList) {
        this.mAnagramsList = anagramsList;
    }
}
