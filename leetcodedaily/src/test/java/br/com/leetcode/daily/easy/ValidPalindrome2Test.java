package br.com.leetcode.daily.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindrome2Test {
    public static void paintAllBuildings(Set<? extends CharSequence> item) {
        System.out.println(item);
    }

    @Test
    void basicTest() {
//        assertTrue(ValidPalindrome2.isPalindrome("aba"));
//        assertTrue(ValidPalindrome2.isPalindrome("abca"));
//        assertFalse(ValidPalindrome2.isPalindrome("abc"));

        var intArray = "Creomildo";

        paintAllBuildings(Set.of("Fernandinha", "Creomildo", "Thamyris"));

        System.out.println();
    }


    public record Cate(String name, Integer age) {
    }

}

