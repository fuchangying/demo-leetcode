package com.example.hot;

import java.util.*;

public class Demo39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(ans, combine, target, candidates, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> combine, int target, int[] cadidates, int index) {
        if (0 == target) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        if (index == cadidates.length) {
            return;
        }


        dfs(ans, combine, target, cadidates, index + 1);

        int num = cadidates[index];
        if (target >= num) {
            combine.add(num);
            dfs(ans, combine, target - num, cadidates, index);
            combine.remove(combine.size() - 1);
        }
    }
}
