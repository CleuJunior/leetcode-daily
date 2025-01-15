package br.com.leetcode;

import br.com.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReorderTest {

    @Test
    void sampleTestOne() {
        ListNode head = new ListNode(1, 2, 3, 4);
        Reorder.reorderList(head);
        assertEquals(new ListNode(1, 4, 2, 3), head);
    }

    @Test
    void sampleTestTwo() {
        ListNode head = new ListNode(1, 2, 3, 4, 5);
        Reorder.reorderList(head);
        assertEquals(new ListNode(1, 5, 2, 4, 3), head);
    }
}