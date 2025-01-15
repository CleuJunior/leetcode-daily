package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxAverageTest {

    @Test
    void sampleTest() {
        assertEquals(12.75, MaxAverage.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        assertEquals(5.0, MaxAverage.findMaxAverage(new int[]{5}, 1));
    }
}