package com.company;

public class RotateString {

    public static boolean rotateString(String a, String b) {
        if (a.equals(b)) {
            return true;
        }

        if (a.length()<1 || b.length()!=a.length()) {
            return false;
        }

        String current = a;
        for (int i=0; i<a.length(); i++) {
            String rotated = rotateString(current);
            current = rotated;
            if (rotated.equals(b)) {
                return true;
            }
        }

        return false;
    }

    public static String rotateString(String s) {
        return s.substring(1,s.length())+s.substring(0,1);
    }
}
