package br.com.leetcode;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        // Preprocess: Remove non-alphanumeric characters and convert to lowercase
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int left = 0;
        int right = s.length() - 1;

        // Two-pointer comparison
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false; // Characters mismatch, not a palindrome
            }
            left++;
            right--;
        }

        return true; // All characters match
    }
}