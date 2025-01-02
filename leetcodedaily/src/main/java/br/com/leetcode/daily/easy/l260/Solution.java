package br.com.leetcode.daily.easy.l260;

import br.com.leetcode.daily.common.ListNode;

public class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;     // A pointer to the previous node
        ListNode current = head; // A pointer to the current node

        while (current != null) {
            ListNode next = current.next; // Save the next node
            current.next = prev;         // Reverse the pointer
            prev = current;             // Move prev one step forward
            current = next;            // Move current one step forward
        }

        return prev; // Return of the reverse linked list
    }
}
