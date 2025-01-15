package br.com.leetcode;

public class MaxAverage {

    public static double findMaxAverage(int[] nums, int k) {
        double currentMax = 0d;

        // Calculate the sum of the first window
        for (int i = 0; i < k; i++) {
            currentMax += nums[i];
        }

        double max = currentMax;

        // Slide the window through the array
        for (int i = k; i < nums.length; i++) {
            currentMax = currentMax + nums[i] - nums[i - k];
            max = Math.max(max, currentMax);
        }

        return max / k;
    }
}