package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MostWaterTest {

    @Test
    void basicTest() {
        assertEquals(49, MostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        assertEquals(1, MostWater.maxArea(new int[]{1, 1}));
    }
}