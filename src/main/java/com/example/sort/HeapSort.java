package com.example.sort;

/**
 * 堆排序
 */
public class HeapSort {
    static int heapLen;


    public static int[] heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i > 0; i--) {
            heapify(arr, i);
        }

        return arr;
    }

    private static void heapify(int[] arr, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (right < heapLen && arr[right] > arr[largest]) {
            largest = left;

        }

        if (left < heapLen && arr[left] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(arr, largest, i);
            heapify(arr, largest);
        }

    }


    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
