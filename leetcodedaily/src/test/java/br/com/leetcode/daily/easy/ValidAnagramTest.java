package br.com.leetcode.daily.easy;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    @Test
    void caseOne() {
        assertTrue(ValidAnagram.isAnagram("anagram", "nagaram"));
    }

    @Test
    void caseTwo() {
        assertFalse(ValidAnagram.isAnagram("rat", "car"));
    }

}