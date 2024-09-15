package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {

    @Test
    void simpleTest() {
        assertEquals(3, BinarySearch.search(new int[]{-1, 0, 2, 4, 6, 8}, 4));
        assertEquals(-1, BinarySearch.search(new int[]{-1, 0, 2, 4, 6, 8}, 3));
    }

}