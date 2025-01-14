package br.com.common;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int... values) {
        this.val = values[0];

        for (int i = 1; i < values.length; i++) {
            add(values[i]);
        }
    }

    public void add(int val) {
        if (next == null) {
            next = new ListNode(val);

        } else {
            ListNode temp = next;
            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = new ListNode(val);
        }
    }

    @Override
    public String toString() {
        return "{val: " + val + ", next: " + next + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ListNode listNode))
            return false;

        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
