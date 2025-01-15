package br.com.leetcode;

public class Zero {

    public static void moveZeroes(int[] nums) {
        int lastNonZeroIndex = 0; // Tracks where the next non-zero element should go

        // Step 1: Move all non-zero elements to the front
        for (int current = 0; current < nums.length; current++) {
            if (nums[current] != 0) {
                // Swap non-zero element with the element at lastNonZeroIndex
                int temp = nums[current];
                nums[current] = nums[lastNonZeroIndex];
                nums[lastNonZeroIndex] = temp;

                lastNonZeroIndex++;
            }
        }
    }
}