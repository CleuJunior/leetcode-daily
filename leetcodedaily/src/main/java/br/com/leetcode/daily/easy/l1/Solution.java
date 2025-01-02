package br.com.leetcode.daily.easy.l1;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> sum = new HashMap<>();
        int[] arr = new int[2];
        int index = 0;

        for (int num : nums) {
            if (sum.get(num) != null) {
                arr[0] = sum.get(num);
                arr[1] = index;
                break;
            }

            sum.put(target-num, index);
            index++;
        }

        return arr;
    }
}
