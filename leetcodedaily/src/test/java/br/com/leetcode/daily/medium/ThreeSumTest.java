package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    @Test
    void basicTest() {
        assertEquals(List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)), ThreeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        assertEquals(List.of(), ThreeSum.threeSum(new int[]{0, 1, 1}));
        assertEquals(List.of(List.of(0, 0, 0)), ThreeSum.threeSum(new int[]{0, 0, 0}));
    }

}