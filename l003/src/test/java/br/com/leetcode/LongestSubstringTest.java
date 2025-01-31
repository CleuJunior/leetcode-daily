package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    void lengthOfLongestSubstringTest() {
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, LongestSubstring.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("pwwkew"));
        assertEquals(3, LongestSubstring.lengthOfLongestSubstring("dvdf"));
    }
}