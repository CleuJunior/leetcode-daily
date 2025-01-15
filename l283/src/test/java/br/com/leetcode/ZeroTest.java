package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static br.com.leetcode.Zero.moveZeroes;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ZeroTest {

    @Test
    void sampleTest() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

}