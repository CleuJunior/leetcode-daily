package br.com.leetcode;

import java.util.HashMap;
import java.util.Map;


public class Anagram {

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            mapS.merge(s.charAt(i), 1, Integer::sum);
            mapT.merge(t.charAt(i), 1, Integer::sum);
        }

        return mapS.equals(mapT);
    }
}