package br.com.leetcode.daily.easy;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        var string = String.valueOf(x);

        var left = 0;
        var right = string.length() - 1;

        while (left < right) {
            if (string.charAt(left) != string.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
