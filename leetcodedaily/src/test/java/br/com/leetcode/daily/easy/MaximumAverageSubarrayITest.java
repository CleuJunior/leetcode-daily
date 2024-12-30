package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAverageSubarrayITest {

    @Test
    void basicTest() {
        assertEquals(12.75, MaximumAverageSubarrayI.findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4));
        assertEquals(5.00, MaximumAverageSubarrayI.findMaxAverage(new int[]{5}, 1));
    }

}