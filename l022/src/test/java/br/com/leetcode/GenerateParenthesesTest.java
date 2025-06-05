package br.com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    @Test
    void sampleTest() {
        assertEquals(
                List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                GenerateParentheses.generateParenthesis(3));

        assertEquals(
                List.of("()"),
                GenerateParentheses.generateParenthesis(1));
    }
}