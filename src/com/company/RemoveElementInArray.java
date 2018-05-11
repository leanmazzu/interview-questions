package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveElementInArray {

    public static int removeElement(ArrayList<Integer> a, int b) {
        LinkedList<Integer> positions = new LinkedList<>();

        int found = 0;
        for (int i=0; i<a.size(); i++) {
            if (a.get(i)==b) {
                found++;
                positions.add(i);
            } else if (!positions.isEmpty()) {
                int pos = positions.removeFirst();
                a.set(pos, a.get(i));
            }
        }

        int newSize= a.size()-found;

        ArrayList<Integer> newArr = new ArrayList<>();
        for (int i=0; i<newSize; i++) {
            newArr.add(a.get(i));
        }

        return newSize;
    }
}
