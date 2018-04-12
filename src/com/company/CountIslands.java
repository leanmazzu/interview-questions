package com.company;

public class CountIslands {

    public static int countIslands(int[][] graph) {
        int result = 0;
        if (graph.length > 0) {
            int row = graph.length;
            int col = graph[0].length;
            result = countIslandsInternal(graph, row, col);
        }

        return result;
    }

    private static int countIslandsInternal(int[][] graph, int row, int col) {
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (isValidForDFS(graph, i, row, j, col, visited)) {
                    doDFS(graph, i, row, j, col, visited);
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isValidForDFS(int[][] graph, int i, int rowSize, int j, int colSize, boolean[][] visited) {
        return (i >= 0 && i < rowSize) &&
                (j >= 0 && j < colSize) &&
                (graph[i][j] == 1 && !visited[i][j]);
    }

    private static void doDFS(int[][] graph, int i, int rowSize, int j, int colSize, boolean[][] visited) {
        int[] rowNeighbor = new int[]{ 1,  0, -1,-1,-1, 0, 1, 1};
        int[] colNeighbor = new int[]{-1, -1, -1, 0, 1, 1, 1, 0};

        visited[i][j] = true;

        for (int k=0; k<8; k++) {
            int neighborRow = i+rowNeighbor[k];
            int neighborCol = j+colNeighbor[k];

            if (isValidForDFS(graph, neighborRow, rowSize,neighborCol, colSize, visited)) {
                doDFS(graph, neighborRow, rowSize, neighborCol, colSize, visited);
            }
        }
    }
}
