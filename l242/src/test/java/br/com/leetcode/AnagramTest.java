package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Test
    void isAnagramTest() {
        assertTrue(Anagram.isAnagram("anagram", "nagaram"));
        assertFalse(Anagram.isAnagram("rat", "car"));
    }
}