package com.company;

import java.util.HashMap;

public class MostWantedDestination {

    public static String mostWanted(String[] destinations) {
        HashMap<String, Integer> count = new HashMap<>();

        for (String dest : destinations) {
            if (!count.containsKey(dest)) {
                count.put(dest, 1);
            } else {
                count.put(dest, count.get(dest) + 1);
            }
        }

        String maxDest = null;
        int maxValue = Integer.MIN_VALUE;
        for (HashMap.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxDest = entry.getKey();
            }
        }

        return maxDest;
    }
}
