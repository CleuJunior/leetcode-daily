package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (closeToOpen.get(c).equals(stack.peek())) {
                    stack.pop();
                } else
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}