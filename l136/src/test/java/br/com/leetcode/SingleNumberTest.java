package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static br.com.leetcode.SingleNumber.singleNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SingleNumberTest {

    @Test
    void sampleTest() {
        assertEquals(1, singleNumber(new int[]{2, 2, 1}));
        assertEquals(4, singleNumber(new int[]{4, 1, 2, 1, 2}));
        assertEquals(1, singleNumber(new int[]{1}));
    }
}