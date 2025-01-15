package br.com.leetcode;

import br.com.common.ListNode;
import org.junit.jupiter.api.Test;

import static br.com.leetcode.Reverse.reverseList;
import static org.junit.jupiter.api.Assertions.*;

class ReverseTest {

    @Test
    void sampleTest() {
        assertEquals(new ListNode(5, 4, 3, 2, 1), reverseList(new ListNode(1, 2, 3, 4, 5)));
        assertEquals(new ListNode(2, 1), reverseList(new ListNode(1, 2)));
        assertEquals(new ListNode(), reverseList(new ListNode()));
    }

}