package com.example.hot;

public class Demo152 {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        long[] dpMax = new long[length];
        long[] dpMin = new long[length];
        for (int i = 0; i < length; i++) {
            dpMax[i] = nums[i];
            dpMin[i] = nums[i];
        }

        for (int i = 1; i < length; i++) {
            dpMax[i] = Math.max(dpMax[i - 1] * nums[i], Math.max(dpMin[i - 1] * nums[i], nums[i]));
            dpMin[i] = Math.min(dpMax[i - 1] * nums[i], Math.min(dpMin[i - 1] * nums[i], nums[i]));
            if (dpMin[i] < (-1 << 31)) {
                dpMin[i] = nums[i];
            }
        }

        int ans = (int) dpMax[0];
        for (int i = 1; i < dpMax.length; i++) {
            ans = Math.max(ans, (int) dpMax[i]);
        }

        return ans;

    }
}
