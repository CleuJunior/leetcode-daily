package br.com.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EncryptDecryptTest {

    @Test
    void sampleTestEncoded() {
        assertEquals("4:leet4:code4:love3:you", EncryptDecrypt.encode(List.of("leet", "code", "love", "you")));
        assertEquals("2:we3:say1::3:yes", EncryptDecrypt.encode(List.of("we", "say", ":", "yes")));
    }

    @Test
    void sampleTestDecoded() {
        assertEquals(List.of("leet", "code", "love", "you"), EncryptDecrypt.decode("4:leet4:code4:love3:you"));
        assertEquals(List.of("we", "say", ":", "yes"), EncryptDecrypt.decode("2:we3:say1::3:yes"));
    }
}