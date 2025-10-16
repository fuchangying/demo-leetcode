package com.example.hot;

public class Demo647 {
    public int countSubstrings(String s) {
        int length = s.length();
        int ans = length;
        for (int i = 0; i < length; i++) {
            int left = i - 1;
            int right = i + 1;
            while (left >= 0 && right < length && (s.charAt(left--) == s.charAt(right++))) {
                ans++;
            }

            left = i;
            right = i + 1;
            while (left >= 0 && right < length && (s.charAt(left--) == s.charAt(right++))) {
                ans++;
            }

        }
        return ans;
    }
}
