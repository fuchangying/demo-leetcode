package com.example.sort;

/**
 * 希尔排序 插入排序的高效版本
 */
public class ShellSort {

    public static int[] shellSort(int[] arr) {
        int n = arr.length;
        int gap = n / 2;

        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int preIndex = i - gap;
                int current = arr[i];
                while (preIndex >= 0 && current < arr[preIndex]) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = current;
            }
            gap = gap / 2;
        }
        return arr;
    }
}
