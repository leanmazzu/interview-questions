package com.company;

public class OneEditDistance {

    public static boolean isOneEditDistance(String s1, String s2) {

        int lengthDiffer = Math.abs(s1.length()-s2.length());

        if (lengthDiffer>1) {
            return false;
        }

        int edits = 0;

        int s1Size = s1.length();
        int s2Size = s2.length();

        int i=0;
        int j=0;

        while (i<s1Size && j<s2Size) {
            char s1Char = s1.charAt(i);
            char s2Char = s2.charAt(j);

            if (s1Char!=s2Char) {
                if (edits>0) {
                    return false;
                }

                if (s1Size>s2Size) {
                    i++;
                } else if (s2Size>s1Size) {
                    j++;
                } else {
                    i++;
                    j++;
                }
                edits++;
            } else {
                i++;
                j++;
            }
        }

        if (i<s1Size || j<s2Size) {
            edits++;
        }

        return edits == 1;
    }
}
