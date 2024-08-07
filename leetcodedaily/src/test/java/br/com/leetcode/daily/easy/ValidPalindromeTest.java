package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {

    @Test
    void basicTest() {
        assertTrue(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        assertFalse(ValidPalindrome.isPalindrome("race a car"));
        assertTrue(ValidPalindrome.isPalindrome(" "));
        assertFalse(ValidPalindrome.isPalindrome("0P"));
    }

}