package com.example.hot;

import java.util.HashSet;
import java.util.List;

public class Demo139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        HashSet<String> set = new HashSet<>(wordDict);

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String substring = s.substring(j, i);
                if (set.contains(substring) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }

        }

        return dp[s.length()];
    }

    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str.substring(0, 0));
    }
}
