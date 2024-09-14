package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TopKTest {

    @Test
    void basicTest() {
        assertArrayEquals(new int[]{1, 2}, TopK.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        assertArrayEquals(new int[]{10, 100, 1000}, TopK.topKFrequent(new int[]{10, 100, 10, 1000, 10, 100}, 3));
        assertArrayEquals(new int[]{1}, TopK.topKFrequent(new int[]{1}, 1));
    }

}