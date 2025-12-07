package com.example.hot;

import java.util.HashMap;

/**
 * <a href='https://leetcode.cn/problems/subarray-sum-equals-k/?envType=problem-list-v2&envId=t79LTxQN'>和为K的子数组</a>
 */
public class Demo560 {


    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;
        HashMap<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);

        for (int num : nums) {
            prefixSum += num;
            if (prefixCount.containsKey(prefixSum - k)) {
                count += prefixCount.get(prefixSum - k);
            }

            prefixCount.put(prefixSum, prefixCount.getOrDefault(prefixSum, 0) + 1);

        }
        return count;


    }
}
