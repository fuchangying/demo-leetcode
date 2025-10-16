package com.example.hot;

import java.util.HashSet;

public class Demo128 {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }


        int max = 0;
        for (Integer num : numSet) {
            if (numSet.contains(num - 1)) {
                continue;
            }
            int current = num;
            int length = 1;
            while (numSet.contains(++num)) {
                length++;
            }
            max = Math.max(max, length);

        }

        return max;
    }
}
