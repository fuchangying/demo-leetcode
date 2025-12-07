package com.example.hot;

import java.util.Collections;

public class Demo31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {

            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);

        }
        reserve(nums, i + 1);


    }

    public void reserve(int[] nums, int start) {
        int l = start;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);

        }

    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
