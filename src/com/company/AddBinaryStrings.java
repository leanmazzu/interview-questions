package com.company;

public class AddBinaryStrings {

    public static String addBinary(String s1, String s2) {

        int i = s1.length()-1;
        int j = s2.length()-1;

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        while (i >= 0 && j >= 0) {
            int value1 = Character.getNumericValue(s1.charAt(i));
            int value2 = Character.getNumericValue(s2.charAt(j));
            int result = value1 + value2 + carry;

            if (result > 1) {
                carry = 1;
                sb.append("0");
            } else {
                carry = 0;
                sb.append(String.valueOf(result));
            }
            i--;
            j--;
        }

        if (i>0) {
            while (i>=0) {
                int result = Character.getNumericValue(s1.charAt(i)) + carry;
                if (result>1) {
                    sb.append("0");
                    carry = 1;
                } else {
                    carry = 0;
                    sb.append(String.valueOf(result));
                }
                i--;
            }
        }

        if (j>0) {
            while (j>=0) {
                int result = Character.getNumericValue(s2.charAt(j)) +carry;
                if (result>1) {
                    sb.append("0");
                    carry = 1;
                } else {
                    carry = 0;
                    sb.append(String.valueOf(result));
                }
                j--;
            }
        }

        return sb.reverse().toString();
    }
}
