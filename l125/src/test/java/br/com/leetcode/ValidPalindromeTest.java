package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {

    @Test
    void sampleTest() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
        assertTrue(ValidPalindrome.isPalindrome(" "));
    }
}