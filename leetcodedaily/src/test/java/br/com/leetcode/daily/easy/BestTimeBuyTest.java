package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeBuyTest {

    @Test
    void simpleTest() {
        assertEquals(5, BestTimeBuy.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(0, BestTimeBuy.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

}