package br.com.leetcode.daily.easy;

import java.util.HashSet;

public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        var set = new HashSet<Integer>();

        for (int num : nums) {
            if (set.contains(num))
                return true;

            set.add(num);
        }

        return false;
    }
}
