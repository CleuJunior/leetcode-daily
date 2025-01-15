package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HammingTest {

    @Test
    void hammingWeightTest() {
        assertEquals(3, Hamming.hammingWeight(11));
        assertEquals(1, Hamming.hammingWeight(128));
        assertEquals(0, Hamming.hammingWeight(0));
    }

}