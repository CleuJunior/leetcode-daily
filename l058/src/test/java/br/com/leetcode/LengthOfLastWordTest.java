package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LengthOfLastWordTest {

    @Test
    void basicTests() {
        assertEquals(5, LengthOfLastWord.lengthOfLastWord("Hello World"));
        assertEquals(4, LengthOfLastWord.lengthOfLastWord("   fly me   to   the moon  "));
        assertEquals(6, LengthOfLastWord.lengthOfLastWord("luffy is still joyboy"));
    }

}