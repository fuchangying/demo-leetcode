package com.example.hot;

import java.util.*;

public class Demo448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            if (nums[x] <= n) {
                nums[x] = nums[x] + n;
            }

        }

        List<Integer> ret = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }

        return ret;

    }
}
