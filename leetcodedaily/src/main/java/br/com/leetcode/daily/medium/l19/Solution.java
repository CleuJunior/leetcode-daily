package br.com.leetcode.daily.medium.l19;

import br.com.leetcode.daily.common.ListNode;

public class Solution {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Add a dummy node at the beginning
        ListNode dummy = new ListNode(0, head);

        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Move `first` pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Move both pointers until `first` reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Skip the target node
        second.next = second.next.next;

        // Return the modified list
        return dummy.next;
    }
}