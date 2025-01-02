package br.com.leetcode.daily.easy;

public class MissingNumber {

    public static int missingNumber(int[] nums) {
        int ans = 0;

        for (int i = 1; i <= nums.length; i++) {
            ans = ans ^ i;
        }

        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}