package com.example.hot;

import java.util.*;

public class Demo49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            List<String> strings = map.computeIfAbsent(new String(charArray), s ->
                    new ArrayList<String>());
            strings.add(str);
        }

        return  new ArrayList<List<String>>(map.values());
    }
}
