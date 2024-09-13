package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumTest {

    @Test
    void basicTest() {
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 3}, TwoSum.twoSum(new int[]{2, 3, 4}, 6));
        assertArrayEquals(new int[]{1, 2}, TwoSum.twoSum(new int[]{-1, 0}, -1));
    }
}
