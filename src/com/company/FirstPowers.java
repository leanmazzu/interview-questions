package com.company;

public class FirstPowers {

    public static int[] firstNPowersOfTwo(int n) {
        int[] results = new int[n];

        results[0] = 2;
        int previous = 2;
        for (int i=1; i<n; i++) {
            results[i] = previous * 2;
            previous = results[i];
        }

        return results;
    }
}
