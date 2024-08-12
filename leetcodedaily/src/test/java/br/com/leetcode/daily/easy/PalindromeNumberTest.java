package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromeNumberTest {

    @Test
    void basicTest() {
        assertTrue(PalindromeNumber.isPalindrome(121));
        assertFalse(PalindromeNumber.isPalindrome(-121));
        assertFalse(PalindromeNumber.isPalindrome(10));
    }

}