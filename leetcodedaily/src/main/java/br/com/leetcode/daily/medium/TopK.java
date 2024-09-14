package br.com.leetcode.daily.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopK {

    public static int[] topKFrequent(int[] nums, int k) {
        var count = new HashMap<Integer, Integer>();

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] freq = new ArrayList[nums.length + 1];

        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            var frequency = entry.getValue();
            freq[frequency].add(entry.getKey());
        }

        var res = new int[k];
        var index = 0;

        for (int i = freq.length - 1; i >= 0; i--) {
            for (int num : freq[i]) {
                res[index++] = num;
                if (index == k) {
                    return res;
                }
            }
        }

        return new int[0];
    }
}
