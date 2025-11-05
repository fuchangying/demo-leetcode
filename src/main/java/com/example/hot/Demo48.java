package com.example.hot;

public class Demo48 {
    public void rotate(int[][] matrix) {

        // 两次翻转 first 水平翻转  second 斜对角线翻转
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[m - 1 - i][j];
                matrix[m - 1 - i][j] = temp;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
