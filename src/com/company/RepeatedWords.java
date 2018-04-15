package com.company;

import java.util.HashMap;

public class RepeatedWords {

    public static int amountRepeated(String[] words) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        int repeated = 0;
        for (String word : words) {
            if (!wordCount.containsKey(word)) {
                wordCount.put(word,1);
            } else {
                if (wordCount.get(word)==1) {
                    repeated++;
                }
                wordCount.put(word, wordCount.get(word) +1);
            }
        }

        return repeated;
    }
}
