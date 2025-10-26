package com.example.hot;

import java.util.Arrays;
import java.util.Comparator;

public class Demo406 {
    public int[][] reconstructQueue(int[][] people) {
        int length = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                } else {
                    return o2[1] - o1[1];
                }

            }
        });

        int[][] ans = new int[length][];


        for (int[] person : people) {
            int count = person[1] + 1;
            for (int i = 0; i < length; i++) {
                if (ans[i] == null) {
                    count--;
                }

                if (count == 0) {
                    ans[i] = person;
                    break;
                }
            }
        }
        return ans;
    }


}
