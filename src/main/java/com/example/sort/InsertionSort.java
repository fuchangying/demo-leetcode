package com.example.sort;

/**
 * 插入排序
 */
public class InsertionSort {

    public static int[] insertionSort(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {

            int preIndex = i - 1;
            int current = arr[i];

            while (preIndex >= 0 && current < arr[preIndex]) {

                arr[preIndex + 1] = arr[preIndex];

                preIndex -= 1;
            }

            arr[preIndex + 1] = current;

        }

        return arr;


    }
}
