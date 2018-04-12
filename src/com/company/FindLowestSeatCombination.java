package com.company;

public class FindLowestSeatCombination {

    public static int lowestPrice(int[][] seats, int p) {
        if (p<=seats.length && p>0) {
            int min = Integer.MAX_VALUE;

            for (int r=0; r<seats.length; r++) {
                int previousSum =0;
                for (int i =0; i<p; i++) {
                    previousSum+=seats[r][i];
                }

                if (previousSum<min) {
                    min = previousSum;
                }

                previousSum -= seats[r][0];

                for (int i=1; i+p-1<seats[r].length; i++) {
                    int current = previousSum + seats[r][i+p-1];

                    if (current<min) {
                        min = current;
                    }

                    previousSum = current - seats[r][i];
                }
            }

            return min;
        }

        return -1;
    }
}
