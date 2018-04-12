package com.company;

import java.util.PriorityQueue;

public class ArraySmallestElements {

    public static int findSmallestElement(int[] arr, int k) {
        if (k>arr.length) {
            throw new IllegalArgumentException("K can't be greather than arr size");
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<arr.length; i++) {
            pq.add(arr[i]);
        }

        int num = 0;
        for (int i=0; i<k; i++) {
            num = pq.poll();
        }

        return num;
    }
}
