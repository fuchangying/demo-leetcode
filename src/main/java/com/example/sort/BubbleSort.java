package com.example.sort;

/**
 * 冒泡排序算法
 */
public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 1; i < arr.length; i++) {

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }

        }

        return arr;
    }
}
