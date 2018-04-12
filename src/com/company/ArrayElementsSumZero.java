package com.company;

import java.util.HashMap;
import java.util.HashSet;

public class ArrayElementsSumZero {

    public static boolean canSumToZeroWithSort(int[] arr) {
        ArraySorting.mergeSort(arr);

        int left;
        int right;

        for (int i=0; i<arr.length; i++) {
            left = i+1;
            right = arr.length-1;

            while (left<right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return true;
                } else if (sum>0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return false;
    }

    public static boolean canSumToZeroWithSet(int[] arr) {
        if (arr.length>=3) {

            HashMap<Integer,HashSet<Integer>> sumCount = new HashMap<>();
            for (int i=0; i<arr.length; i++) {
                for (int j=i+1; j<arr.length; j++) {
                    int sum = arr[i] + arr[j];
                    HashSet<Integer> indexes = new HashSet<>();
                    indexes.add(i);
                    indexes.add(j);
                    sumCount.put(sum,indexes);
                }
            }

            for (int i=0; i<arr.length; i++) {
                int valueToLook = arr[i];
                if (valueToLook>0) {
                    valueToLook = -valueToLook;
                }
                if (sumCount.containsKey(valueToLook) && !sumCount.get(valueToLook).contains(i)) {
                    return true;
                }
            }

        }
        return false;
    }


}
