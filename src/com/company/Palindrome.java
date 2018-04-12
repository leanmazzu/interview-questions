package com.company;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        if (s.length()<2) {
            return false;
        }
        int i=0,j= s.length()-1;
        while (i<=j) {
            char firstHalf = s.charAt(i);
            char secondHalf = s.charAt(j);

            if (isLetter(firstHalf) && isLetter(secondHalf)) {
                if (firstHalf!=secondHalf) {
                    return false;
                }
                i++;
                j--;
            } else if (isLetter(secondHalf)) {
                i++;
            } else if (isLetter(firstHalf)) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    public static boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }
}
