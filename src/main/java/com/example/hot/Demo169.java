package com.example.hot;

public class Demo169 {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer cadidate = null;
        for (int num : nums) {
            if (count == 0) {
                cadidate = num;
            }

            count += num == cadidate ? 1 : -1;

        }
        return cadidate;

    }

}
