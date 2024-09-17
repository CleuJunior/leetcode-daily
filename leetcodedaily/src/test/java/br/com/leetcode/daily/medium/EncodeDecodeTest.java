package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EncodeDecodeTest {

    @Test
    void basicTest() {
        assertEquals("4#neet4#code4#love3#you", EncodeDecode.encode(List.of("neet","code","love","you")));
        assertEquals(List.of("neet","code","love","you"), EncodeDecode.decode("4#neet4#code4#love3#you"));
    }

}