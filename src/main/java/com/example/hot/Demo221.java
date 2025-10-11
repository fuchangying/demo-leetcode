package com.example.hot;

public class Demo221 {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        int i = maximalSquare(matrix);
        System.out.println(i);


    }

    public static int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] ans = new int[rows][columns];
        int maxSize = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {

                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        ans[i][j] = 1;
                    } else {
                        ans[i][j] = 1 + Math.min(Math.min(ans[i - 1][j], ans[i][j - 1]), ans[i - 1][j - 1]);

                    }
                }
                maxSize = Math.max(ans[i][j], maxSize);

            }
        }
        return maxSize * maxSize;


    }
}
