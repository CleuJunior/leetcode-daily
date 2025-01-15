package br.com.leetcode;

public class Majority {

    public static int majorityElement(int[] nums) {
        int ans = -1;
        int count = 0;

        for (int num : nums) {
            if (count == 0)
                ans = num;

            if (ans == num) {
                count += 1;

            } else {
                count -= 1;
            }
        }

        return ans;
    }
}