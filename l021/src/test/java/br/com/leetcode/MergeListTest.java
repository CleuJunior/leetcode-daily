package br.com.leetcode;

import br.com.common.ListNode;
import org.junit.jupiter.api.Test;

import static br.com.leetcode.MergeList.mergeTwoLists;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MergeListTest {

    @Test
    void sampleTestOne() {
        ListNode node = mergeTwoLists(new ListNode(1, 2, 4), new ListNode(1, 3, 4));
        assertEquals(new ListNode(1, 1, 2, 3, 4, 4), node);
    }

    @Test
    void sampleTestTwo() {
        ListNode node = mergeTwoLists(null, null);
        assertNull(node);
    }
}