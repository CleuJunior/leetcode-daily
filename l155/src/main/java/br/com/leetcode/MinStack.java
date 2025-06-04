package br.com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private final Deque<Integer> mainStack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public void push(int val) {
        this.mainStack.push(val);

        if (this.minStack.peek() != null) {
            val = Math.min(val, minStack.peek());
            minStack.push(val);

        } else {
            minStack.push(val);
        }
    }

    public void pop() {
        this.mainStack.pop();
        this.minStack.pop();
    }

    public int top() {
        return this.mainStack.peek();
    }

    public int getMin() {
        return this.minStack.peek();

    }
}