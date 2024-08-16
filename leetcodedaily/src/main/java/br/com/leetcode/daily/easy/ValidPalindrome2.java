package br.com.leetcode.daily.easy;

public class ValidPalindrome2 {

    public static boolean isPalindrome(String s) {
        var left = 0;
        var right = s.length() - 1;
        var count = 0;

        while(left < right) {
            if (s.charAt(left) != s.charAt(right))
                count++;

            if (count > 1) return false;

            left++;
            right--;
        }

        return true;
    }
}