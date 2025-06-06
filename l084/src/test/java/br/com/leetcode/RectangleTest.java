package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    @Test
    void sampleTest() {
        assertEquals(10, Rectangle.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        assertEquals(4, Rectangle.largestRectangleArea(new int[]{2, 4}));
    }
}