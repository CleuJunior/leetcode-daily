package br.com.leetcode.daily.easy;

public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        var stdString = new StringBuilder();

        for(var c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c))
                stdString.append(Character.toLowerCase(c));
        }

        var left = 0;
        var right = stdString.toString().length() - 1;

        while(left < right) {
            if (stdString.toString().charAt(left) != stdString.toString().charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}