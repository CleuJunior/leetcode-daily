package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TemperaturesTest {

    @Test
    void lengthOfLongestSubstringTest() {
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, Temperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        assertArrayEquals(new int[]{1, 1, 1, 0}, Temperatures.dailyTemperatures(new int[]{30, 40, 50, 60}));
        assertArrayEquals(new int[]{1, 1, 0}, Temperatures.dailyTemperatures(new int[]{30, 60, 90}));
    }
}