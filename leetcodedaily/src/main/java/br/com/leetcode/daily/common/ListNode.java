package br.com.leetcode.daily.common;

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
}
