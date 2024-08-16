package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindrome2Test {

    @Test
    void basicTest() {
        assertTrue(ValidPalindrome2.isPalindrome("aba"));
        assertTrue(ValidPalindrome2.isPalindrome("abca"));
        assertFalse(ValidPalindrome2.isPalindrome("abc"));
    }

}