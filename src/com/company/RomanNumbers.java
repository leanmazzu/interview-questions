package com.company;

import java.util.HashMap;
import java.util.TreeMap;

public class RomanNumbers {

    private HashMap<Character, Integer> romanToIntMap = new HashMap<>();
    private TreeMap<Integer, String> intToRomanMap = new TreeMap<>();

    public RomanNumbers() {
        initRomanToIntMap();
        initIntToRomanMap();
    }

    public int convertRomanToInt(String roman) {
        int value = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = roman.length() - 1; i >= 0; i--) {
            int current = romanToIntMap.get(roman.charAt(i));
            if (current < prev) {
                value -= current;
            } else {
                value += current;
            }
            prev = current;
        }

        return value;
    }

    public String convertIntToRomanRecursive(int convert) {
        int num = intToRomanMap.floorKey(convert);

        if (convert == num) {
            return intToRomanMap.get(convert);
        }

        return intToRomanMap.get(num) + convertIntToRomanRecursive(convert-num);
    }

    private void initRomanToIntMap() {
        intToRomanMap.put(1000, "M");
        intToRomanMap.put(900, "CM");
        intToRomanMap.put(500, "D");
        intToRomanMap.put(400, "CD");
        intToRomanMap.put(100, "C");
        intToRomanMap.put(90, "XC");
        intToRomanMap.put(50, "L");
        intToRomanMap.put(40, "XL");
        intToRomanMap.put(10, "X");
        intToRomanMap.put(9, "IX");
        intToRomanMap.put(5, "V");
        intToRomanMap.put(4, "IV");
        intToRomanMap.put(1, "I");
    }

    private void initIntToRomanMap() {
        intToRomanMap.put(1,"I");
        intToRomanMap.put(5,"V");
        intToRomanMap.put(10,"X");
        intToRomanMap.put(50,"L");
        intToRomanMap.put(100,"C");
        intToRomanMap.put(500,"D");
        intToRomanMap.put(1000, "M");
    }
}
