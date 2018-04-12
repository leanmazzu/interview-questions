package com.company;

import java.util.Arrays;


public class ArrayConsecutiveSum {

    public static int[] findConsecutiveSum(int[] arr, int k) {
        if (arr.length < k) {
            return new int[0];
        }
        if (arr.length == 0) {
            return new int[0];
        }

        int sumToFind = arr.length;

        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }

        if (sum == sumToFind) {
            return Arrays.copyOfRange(arr, 0, k);
        }

        sum -= arr[0];

        for (int i = 1; i + k - 1 < arr.length; i++) {
            int currentSum = sum + arr[i + k - 1];
            if (currentSum == sumToFind) {
                return Arrays.copyOfRange(arr, i, i + k);
            }
            sum = currentSum - arr[i];
        }

        return new int[0];
    }


}
