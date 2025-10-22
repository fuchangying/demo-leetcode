package com.example.hot;

import java.util.*;

public class Demo438 {
    public List<Integer> findAnagrams(String s, String p) {

        int sLength = s.length();
        int pLength = p.length();
        if (sLength < pLength) {
            return new ArrayList<>();
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < pLength; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;

        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLength - pLength; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLength) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;

    }
}
