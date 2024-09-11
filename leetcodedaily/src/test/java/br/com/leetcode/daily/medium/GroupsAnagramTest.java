package br.com.leetcode.daily.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupsAnagramTest {

    @Test
    void basicTest() {
        assertEquals(List.of(List.of("eat", "tea", "ate"), List.of("bat"), List.of("tan", "nat")), GroupsAnagram.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        assertEquals(List.of(List.of("")), GroupsAnagram.groupAnagrams(new String[]{""}));
        assertEquals(List.of(List.of("a")), GroupsAnagram.groupAnagrams(new String[]{"a"}));
    }

}