package com.company;

import java.util.HashMap;

public class NumberToWord {

    private String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    private String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    private String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    private String[] thousands = {"", "thousand", "million", "billion"};

    private String evaluateChunk(int n) {
        int hundredsPlace = n / 100 % 10;
        int tensPlace = n / 10 % 10;
        int onesPlace = n % 10;
        String thousandsChunk = "";
        if (hundredsPlace != 0) {
            thousandsChunk += ones[hundredsPlace] + " " + "hundred";
            if (tensPlace != 0 || onesPlace != 0)
                thousandsChunk += " ";
        }
        if (tensPlace == 1)
            thousandsChunk += teens[onesPlace];
        else if (tensPlace > 1 && onesPlace == 0)
            thousandsChunk += tens[tensPlace];
        else if (tensPlace > 1 && onesPlace != 0)
            thousandsChunk += tens[tensPlace] + " " + ones[onesPlace];
        else
            thousandsChunk += ones[onesPlace];
        return thousandsChunk;
    }

    public String evaluate(int n) {
        if (n == 0) return "zero";
        String englishNum = "";
        String negativeString = "";
        int thousandsPlace = 0;
        if (n < 0) {
            negativeString = "negative";
            n *= -1;
        }
        while (n != 0) {
            int chunk = n % 1000;
            if (chunk != 0)
                englishNum = evaluateChunk(n % 1000) + " " + thousands[thousandsPlace] + " " + englishNum;
            thousandsPlace++;
            n /= 1000;
        }
        return negativeString + englishNum;
    }
}
