package com.example.hot;

public class Demo494 {
    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int neg = diff / 2;
        int length = nums.length;
        int[][] dps = new int[length + 1][neg + 1];
        dps[0][0] = 1;
        for (int i = 1; i <= length; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                if (num > j) {
                    dps[i][j] = dps[i - 1][j];
                } else {
                    dps[i][j] = dps[i - 1][j] + dps[i - 1][j - num];
                }

            }

        }
        return dps[length][neg];
    }
}
