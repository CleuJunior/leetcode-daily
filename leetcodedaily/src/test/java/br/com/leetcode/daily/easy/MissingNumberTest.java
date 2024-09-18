package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MissingNumberTest {

    @Test
    void basicTest() {
        assertEquals(2, MissingNumber.missingNumber(new int[]{3, 0, 1}));
        assertEquals(2, MissingNumber.missingNumber(new int[]{0, 1}));
        assertEquals(8, MissingNumber.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }

}