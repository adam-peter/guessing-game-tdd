package com.adam.game;

public class TextConverter {

    private String[] phonemes = {"cr", "bl", "s", "b", "fl", "c", "s", "m", "pl", "tr", "sn"};

    public String everyOtherCapital(String word) {
        int[] charsUnicodeArray = word.chars().toArray();
        StringBuilder stringBuilder = new StringBuilder(charsUnicodeArray.length);

        for (int i = 0; i < charsUnicodeArray.length; i++) {
            char c = (char) charsUnicodeArray[i];
            stringBuilder.append(i % 2 == 0 ? c : Character.toUpperCase(c));
        }

        return stringBuilder.toString();
    }

    public String spoon(String text) {
        String[] words = text.split(" ");
        String[] wordsPhonemes = new String[2];

        for (int i = 0; i < 2; i++) {
            String word = words[i];
            for (String phoneme : phonemes) {
                if (word.startsWith(phoneme)) {
                    words[i] = word.substring(phoneme.length());
                    wordsPhonemes[i] = phoneme;
                    break;
                }
            }
        }

        return String.format("%s%s %s%s", wordsPhonemes[1], words[0], wordsPhonemes[0], words[1]);
    }
}
