package br.com.leetcode;

import br.com.common.ListNode;

public class MergeList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        // Traverse both lists until one of them is fully processed
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                current = list1;
                // Move the list1 pointer to the next node
                list1 = list1.next;

            } else {
                current.next = list2;
                current = list2;
                // Move the list2 pointer to the next node
                list2 = list2.next;
            }
        }

        // Attach the remaining nodes of the non-empty list (if any)
        current.next = list1 != null ? list1 : list2;

        // Return the merged list starting from the first real node (dummy.next)
        return dummy.next;
    }
}