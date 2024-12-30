package br.com.leetcode.daily.easy;

public class MaximumAverageSubarrayI {

    public static double findMaxAverage(int[] nums, int k) {
        double currentSum = 0;

        for (int i = 0; i < k; i++) {
            currentSum += nums[i];
        }

        double maxSum = currentSum;

        for (int i = k; i < nums.length; i++) {
            currentSum = currentSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum / k;
    }
}
