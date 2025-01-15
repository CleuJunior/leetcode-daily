package br.com.leetcode;

public class Majority {

    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 0;

        // Step 1: Find the candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        // Step 2: Since the majority element always exists, return the candidate
        return candidate;
    }
}