package com.company;

public class MoveZerosToRight {

    public static int[] moveZeros(int[] arr) {
        Integer zeroPosition = null;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0 && zeroPosition == null) {
                zeroPosition = i;
            } else if (arr[i] != 0 && zeroPosition != null) {
                int temp = arr[i];
                arr[i] = 0;
                arr[zeroPosition] = temp;
                zeroPosition = i;
            }
        }

        return arr;
    }
}
