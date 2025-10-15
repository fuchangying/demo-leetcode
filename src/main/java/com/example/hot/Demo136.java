package com.example.hot;

public class Demo136 {
    public int singleNumber(int[] nums) {

        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }
}
