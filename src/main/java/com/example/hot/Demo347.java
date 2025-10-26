package com.example.hot;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Demo347 {
    public int[] topKFrequent(int[] nums, int k) {


        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });

        Map<Integer, Integer> occurences = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = occurences.getOrDefault(num, 0);
            occurences.put(num, orDefault + 1);
        }

        occurences.entrySet().forEach(entry -> {

            int num = entry.getKey();
            int count = entry.getValue();
            if (queue.size() == k) {

                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }

            } else {
                queue.offer(new int[]{num, count});
            }
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            int[] poll = queue.poll();
            ans[i] = poll[0];
        }
        return ans;

    }


}
