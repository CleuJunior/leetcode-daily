package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static br.com.leetcode.Majority.majorityElement;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MajorityTest {

    @Test
    void sampleTest() {
        assertEquals(2, majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
        assertEquals(3, majorityElement(new int[]{3, 2, 3}));
        assertEquals(1, majorityElement(new int[]{1}));
    }

}