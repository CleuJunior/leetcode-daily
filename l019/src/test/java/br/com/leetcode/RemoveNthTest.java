package br.com.leetcode;

import br.com.common.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class RemoveNthTest {

    @Test
    void sampleTestOne() {
        ListNode node = RemoveNth.removeNthFromEnd(new ListNode(1, 2, 3, 4, 5), 2);
        Assertions.assertEquals(new ListNode(1, 2, 3, 5), node);
    }

    @Test
    void sampleTestTwo() {
        ListNode node = RemoveNth.removeNthFromEnd(new ListNode(1), 1);
        Assertions.assertNull(node);
    }

    @Test
    void sampleTestThree() {
        ListNode node = RemoveNth.removeNthFromEnd(new ListNode(1, 2), 1);
        Assertions.assertEquals(new ListNode(1), node);
    }
}