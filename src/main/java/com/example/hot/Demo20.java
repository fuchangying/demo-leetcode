package com.example.hot;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/?envType=problem-list-v2&envId=t79LTxQN">20、有效的括号</a>
 */
public class Demo20 {
    public boolean isValid(String s) {
        HashMap<Character, Character> hashMap = new HashMap<Character, Character>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (hashMap.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != hashMap.get(ch)) {
                    return false;
                }
                stack.pop();

            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}
