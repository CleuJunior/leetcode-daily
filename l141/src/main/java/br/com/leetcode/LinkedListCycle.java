package br.com.leetcode;

import br.com.common.ListNode;

public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;        // Move slow pointer by 1 step
            fast = fast.next.next;  // Move fast pointer by 2 steps

            if (slow == fast) {
                return true; // Pointers meet, cycle detected
            }
        }

        return false; // No cycle detected
    }
}