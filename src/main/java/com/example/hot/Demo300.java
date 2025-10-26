package com.example.hot;

public class Demo300 {
    public int lengthOfLIS(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int ans = 1;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {

            int temp = 1;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    temp = Math.max(temp, dp[j] + 1);
                }
            }

            dp[i] = temp;
            ans = Math.max(ans, dp[i]);
        }
        return ans;

    }
}
