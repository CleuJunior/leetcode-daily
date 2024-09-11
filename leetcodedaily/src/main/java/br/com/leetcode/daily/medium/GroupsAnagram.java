package br.com.leetcode.daily.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsAnagram {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();

        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            ans.computeIfAbsent(key, k -> new ArrayList<>());
            ans.get(key).add(s);
        }

        return new ArrayList<>(ans.values());
    }

}
