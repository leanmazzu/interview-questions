package com.company;

public class AlmostPalindrome {

    public static boolean isAlmostPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        int removedCount = 0;

        while (i < j) {
            int begChar = str.charAt(i);
            int endChar = str.charAt(j);

            if (begChar == endChar) {
                i++;
                j--;
            } else {
                if (begChar == str.charAt(j - 1)) {
                    j--;
                } else if (endChar == str.charAt(i + 1)) {
                    i++;
                }
                removedCount++;
                if (removedCount > 1) return false;
            }
        }
        return true;
    }

    public static int indexToFormPalindrome(String word) {

        int index = -1;
        int i=0;
        int j=word.length()-1;

        int deleteCount = 0;

        while (i<j) {
            char begChar = word.charAt(i);
            char endChar = word.charAt(j);
            if (begChar == endChar) {
                i++;
                j--;
            } else {
                if (word.charAt(i+1) == endChar) {
                    index = i;
                    i++;
                    deleteCount++;
                } else if (word.charAt(j-1) == begChar) {
                    index = j;
                    j--;
                    deleteCount++;
                } else {
                    return -1;
                }
                if (deleteCount>1) {
                    return -1;
                }
            }
        }

        return index;
    }
}
