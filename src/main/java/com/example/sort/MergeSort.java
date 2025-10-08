package com.example.sort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int middle = arr.length / 2;
        int[] arr1 = Arrays.copyOfRange(arr, 0, middle);
        int[] arr2 = Arrays.copyOfRange(arr, middle, arr.length);
        return merge(mergeSort(arr1), mergeSort(arr2));
    }


    public static int[] merge(int[] arr1, int[] arr2) {

        int[] sort_arr = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int arr_index = 0;

        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                sort_arr[arr_index++] = arr1[index1++];
            } else {
                sort_arr[arr_index++] = arr2[index2++];
            }
        }

        if (index1 < arr1.length) {
            while (index1 < arr1.length) {
                sort_arr[arr_index++] = arr1[index1++];
            }

        } else {
            while (index2 < arr2.length) {
                sort_arr[arr_index++] = arr2[index2++];
            }

        }
        return sort_arr;

    }
}
