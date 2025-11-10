package com.example.hot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Demo46 {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer num : nums) {
            integers.add(num);
        }
        dfs(ans, integers, 0, nums.length);
        return ans;

    }

    public void dfs(List<List<Integer>> ans, List<Integer> integers, int index, int length) {
        if (index == length) {
            ans.add(new ArrayList<>(integers));
            return;
        }

        for (int i = index; i < length; i++) {
            Collections.swap(integers, index, i);
            dfs(ans, integers, index + 1, length);
            Collections.swap(integers, index, i);

        }

    }
}
