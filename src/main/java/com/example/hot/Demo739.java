package com.example.hot;

import java.util.Deque;
import java.util.LinkedList;

public class Demo739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];

            while (!stack.isEmpty() && temperatures[stack.peek()] < temp) {
                ans[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);

        }

        return ans;

    }
}
