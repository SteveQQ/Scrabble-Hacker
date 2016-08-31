package com.steveq.scrabblehacker.model;

import java.util.ArrayList;

public class Anagrams {
    private String mOriginWord;
    private ArrayList<String> mAnagramsList;
    private ArrayList<String> mRealWordsList;
    private String mRealWords;

    protected Anagrams(){
        mAnagramsList = new ArrayList<>();
        mRealWordsList = new ArrayList<>();
    }

    public String getOriginWord() {
        return mOriginWord;
    }

    protected void setOriginWord(String originWord) {
        this.mOriginWord = originWord;
    }

    public ArrayList<String> getAnagramsList() {
        return mAnagramsList;
    }

    protected void addAnagramsList(ArrayList<String> anagramsList) {
        for(String anagram : anagramsList){
            mAnagramsList.add(anagram);
        }
    }

    public ArrayList<String> getRealWordsList() {
        return mRealWordsList;
    }

    public void setRealWordsList(ArrayList<String> realWordsList) {
        mRealWordsList = realWordsList;
    }

    public String getRealWords() {
        return mRealWords;
    }

    public void setRealWords() {
        if (mRealWordsList != null) {
            StringBuilder stringBuilder = new StringBuilder();
            for(String word : mRealWordsList) {
                stringBuilder.append(word);
                stringBuilder.append("\n");
            }
            mRealWords = stringBuilder.toString();
        } else {
            mRealWords = "";
        }
    }

    public void clearWordsList(){
        mRealWordsList.clear();
    }

    public void clearAnagramsList(){
        mAnagramsList.clear();
    }
}
