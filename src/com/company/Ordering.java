package com.company;

import java.util.HashMap;

public class Ordering {

    public static boolean isOrdered(String[] words, char[] order) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length; i++) {
            orderMap.put(order[i], i);
        }

        int previousOrderSum = Integer.MIN_VALUE;
        for (String word : words) {
            int orderSum = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!orderMap.containsKey(c)) {
                    return false;
                }
                orderSum += orderMap.get(c);
            }
            if (orderSum < previousOrderSum) {
                return false;
            }
            previousOrderSum = orderSum;
        }

        return true;
    }
}
