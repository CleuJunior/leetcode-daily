package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchTest {

    @Test
    void sampleTest() {
        assertEquals(4, Search.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(6, Search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 2));
        assertEquals(-1, Search.search(new int[]{2, 5, 6, 0, 0, 1, 2}, 7));
    }
}