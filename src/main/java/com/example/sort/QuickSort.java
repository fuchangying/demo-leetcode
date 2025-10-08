package com.example.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 快速排序
 */
public class QuickSort {

    public static int[] quickSort(int[] arr) {
        return quickSort(arr);
    }


    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int p = partion(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p, right);
    }

    public static int partion(int[] arr, int left, int right) {
        int idx = ThreadLocalRandom.current().nextInt(left, right);
        int pv = arr[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && arr[i] < pv) {
                i++;
            }
            while (i <= j && arr[j] > pv) {
                j--;
            }

            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }

        swap(arr, left, j);
        return j;

    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
