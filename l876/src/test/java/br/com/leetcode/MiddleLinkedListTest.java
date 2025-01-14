package br.com.leetcode;

import br.com.common.ListNode;
import org.junit.jupiter.api.Test;

import static br.com.leetcode.MiddleLinkedList.middleNode;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MiddleLinkedListTest {

    @Test
    void sampleTest() {
        ListNode node1 = middleNode(new ListNode(1, 2, 3, 4, 5));
        ListNode node2 = middleNode(new ListNode(1, 2, 3, 4, 5, 6));

        assertEquals(new ListNode(3, 4, 5), node1);
        assertEquals(new ListNode(4, 5, 6), node2);
    }
}