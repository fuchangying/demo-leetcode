package com.example.hot;

public class Demo215 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);

    }

    int quickselect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int x = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i <= j && nums[i] < x) {
                i++;
            }

            while (i <= j && nums[j] > x) {
                j--;
            }

            if (i <= j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        swap(nums, j, left);

        if (k <= j) {
            return quickselect(nums, left, j, k);
        } else {
            return quickselect(nums, j + 1, right, k);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
