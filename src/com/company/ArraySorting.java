package com.company;

public class ArraySorting {

    public static int[] mergeSort(int[] arr) {
        int[] helper = new int[arr.length];
        mergeSort(arr, helper, 0, arr.length - 1);
        return arr;
    }

    private static void mergeSort(int[] arr, int[] helper, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int middle = (leftStart+rightEnd) / 2;
            mergeSort(arr, helper, leftStart, middle);
            mergeSort(arr, helper, middle + 1, rightEnd);
            merge(arr, helper, leftStart, middle, rightEnd);
        }
    }

    private static void merge(int[] arr, int[] helper, int leftStart, int middle, int rightEnd) {
        for (int i = leftStart; i <= rightEnd; i++) {
            helper[i] = arr[i];
        }
        int leftIndex = leftStart;
        int rightIndex = middle + 1;
        int current = leftStart;

        while (leftIndex <= middle && rightIndex <= rightEnd) {
            if (helper[leftIndex] <= helper[rightIndex]) {
                arr[current] = helper[leftIndex];
                leftIndex++;
            } else {
                arr[current] = helper[rightIndex];
                rightIndex++;
            }
            current++;
        }

        if (leftIndex <= middle) {
            for (int i = leftIndex; i <= middle; i++) {
                arr[current] = helper[i];
                current++;
            }
        } else if (rightIndex <= rightEnd) {
            for (int i = rightIndex; i <= rightEnd; i++) {
                arr[current] = helper[i];
                current++;
            }
        }
    }

    public static int[] quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private static void quickSort(int[] arr, int left, int right) {
        int index = partition(arr, left, right);
        if (left < index - 1) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left + (right - left) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;

            while (arr[right] > pivot) right--;

            if (left <= right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }

        return left;
    }
}
