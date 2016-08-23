package com.steveq.scrabblehacker;

import java.util.ArrayList;

public class Generator {
    private String inputWord = null;

    public void setInputWord(String inputWord) {
        this.inputWord = inputWord;
    }

    public int strongOperation(int number) {
        int result = 0;
        if(number == 0) {
            result = 1;
        }
        if(number > 0) {
            result = number * strongOperation(number - 1);
        }
        return result;
    }

    public int permutationWithRepetition(int number, int[] repetitions) {
        int result = 0;
        int numenator = strongOperation(number);
        int denumenator = 1;
        for (int val : repetitions) {
            denumenator = strongOperation(val) * denumenator;
        }
        result = numenator / denumenator;
        return result;
    }

    public int[] getRepetitions(Character[] charList){
        int[] repetitions = new int[charList.length];
        ArrayList<Character> repeatedChar = new ArrayList<Character>();
        for(int i=0; i < charList.length; i++) {
            repetitions[i]=1;
            for(int j=0; j < charList.length; j++) {
                if(j != i){
                    if(charList[j] == charList[i] && repeatedChar.indexOf(charList[i]) == -1) {
                        repetitions[i]++;
                        repeatedChar.add(charList[i]);
                    }
                }
            }
        }
        return repetitions;
    }

    public ArrayList<Character> swapIndexes(ArrayList<Character> charList, int index1, int index2) {
        Character tmp1 = charList.get(index1);
        Character tmp2 = charList.get(index2);
        charList.remove(index1);
        charList.add(index1,tmp2);
        System.out.println(charList);
        charList.remove(index2);
        charList.add(index2,tmp1);
        System.out.println(charList);
        return charList;
    }

    public String getStringRepresentation(ArrayList<Character> list)
    {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch: list)
        {
            builder.append(ch);
        }
        return builder.toString();
    }

    public ArrayList<String> generateAnagrams(String word){

        char[] charsOrigin = word.toCharArray();
        ArrayList<String> anagramsList = new ArrayList<String>();
        String acronymAsString = null;

        ArrayList<Character> charsToModify = new ArrayList<Character>();
        for (int i=0; i < charsOrigin.length; i++) {
            charsToModify.add(charsOrigin[i]);
        }

        if (charsOrigin.length == 2) {
            charsToModify = swapIndexes(charsToModify, 0, 1);
            acronymAsString = getStringRepresentation(charsToModify);
            anagramsList.add(String.valueOf(charsOrigin));
            anagramsList.add(acronymAsString);
        }
        if (charsOrigin.length > 2) {
            Character tempRemovedChar = null;
            for(int i = 0; i < charsOrigin.length; i++) {
                if (i > 0) {
                    charsToModify = swapIndexes(charsToModify, 0, i);
                }
                Character temporaryRemovedLetter = charsToModify.get(0);
                tempRemovedChar = charsToModify.get(0);
                charsToModify.remove(0);
                ArrayList<String> partAnagramsList = new ArrayList<String>(generateAnagrams(getStringRepresentation(charsToModify)));
                String singleWord = null;
                for (int j = 0; j < partAnagramsList.size(); j++) {
                    singleWord = Character.toString(temporaryRemovedLetter) + partAnagramsList.get(j);
                    partAnagramsList.set(j, singleWord);
                }
                for (String el : partAnagramsList) {
                    if (anagramsList.indexOf(el) < 0 ) {
                        anagramsList.add(el);
                    }
                }
                charsToModify.add(0, tempRemovedChar);
                charsToModify = swapIndexes(charsToModify, i, 0);
            }
        }

        anagramsList.remove(inputWord);
        System.out.println(anagramsList.size());
        return anagramsList;
    }
}
