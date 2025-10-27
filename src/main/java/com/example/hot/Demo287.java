package com.example.hot;

public class Demo287 {
    public int findDuplicate(int[] nums) {

        int n = nums.length;
        int left = 1;
        int right = n - 1;

        while (left < right) {

            int mid = (left + right) >> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }


        return left;
    }
}
