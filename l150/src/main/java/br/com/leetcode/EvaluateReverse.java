package br.com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluateReverse {

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!Character.isDigit(token.charAt(0))) {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+": stack.push(a + b); break;
                    case "-": stack.push(a - b); break;
                    case "*": stack.push(a * b); break;
                    case "/": stack.push(a / b); break;
                }

            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}