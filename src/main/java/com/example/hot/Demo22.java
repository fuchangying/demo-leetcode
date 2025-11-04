package com.example.hot;

import java.util.ArrayList;
import java.util.List;

public class Demo22 {
    public List<String> generateParenthesis(int n) {

        char[] list = new char[2 * n];
        List<String> ans = new ArrayList<>();
        dfs(ans, list, 0, 0, 0, n);
        return ans;

    }

    public void dfs(List<String> ans, char[] list, int left, int right, int index, int size) {
        if (index == 2 * size) {
            ans.add(new String(list));
        }
        if (left < size) {
            list[index]='(';
            dfs(ans, list, left + 1, right, index + 1, size);
        }

        if (right < left) {
            list[index]=')';
            dfs(ans, list, left, right + 1, index + 1, size);
        }
    }

}
