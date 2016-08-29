package com.steveq.scrabblehacker.model;

import java.util.ArrayList;
import java.util.Collections;

public class Generator {
    private Anagrams mAnagrams;

    public Generator(String inputWord){
        mAnagrams = new Anagrams(inputWord);
    }

    public String getStringRepresentation(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for (Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }

    private ArrayList<Character> createCharacterList(String string) {
        ArrayList<Character> result = new ArrayList<>();
        for (Character character : string.toCharArray()) {
            result.add(character);
        }
        return result;
    }


    public ArrayList<String> generateAnagrams(String word) {
        ArrayList<String> anagramsList = new ArrayList<>();
        ArrayList<Character> charsToRearrange = createCharacterList(word);
        if (word.length() == 2) {
            Collections.swap(charsToRearrange, 0, 1);
            anagramsList.add(word);
            anagramsList.add(getStringRepresentation(charsToRearrange));
        } else {
            ArrayList<String> metaAnagramsList;
            for (int i = 0; i < word.length(); i++) {
                if (i > 0) {
                    Collections.swap(charsToRearrange, 0, i);
                }
                Character temporaryRemovedLetter = charsToRearrange.get(0);
                charsToRearrange.remove(0);
                metaAnagramsList = new ArrayList<>(generateAnagrams(getStringRepresentation(charsToRearrange)));
                for (int j = 0; j < metaAnagramsList.size(); j++) {
                    metaAnagramsList.set(j, Character.toString(temporaryRemovedLetter) + metaAnagramsList.get(j));
                }
                for (String el : metaAnagramsList) {
                    if (anagramsList.indexOf(el) < 0) {
                        anagramsList.add(el);
                    }
                }
                charsToRearrange.add(0, temporaryRemovedLetter);
                Collections.swap(charsToRearrange, i, 0);
            }
        }
        anagramsList.remove(mAnagrams.getOriginWord());
        return anagramsList;
    }
}