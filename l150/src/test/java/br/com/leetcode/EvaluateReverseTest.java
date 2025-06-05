package br.com.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EvaluateReverseTest {

    @Test
    void sampleTest() {
        assertEquals(9, EvaluateReverse.evalRPN(new String[]{"2","1","+","3","*"}));
        assertEquals(6, EvaluateReverse.evalRPN(new String[]{"4","13","5","/","+"}));
        assertEquals(22, EvaluateReverse.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}