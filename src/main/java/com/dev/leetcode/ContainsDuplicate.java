package com.dev.leetcode;

import java.util.Arrays;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        int[] numsSorted = Arrays.stream(nums).sorted().toArray();
        for(int i=0; i < numsSorted.length; i++) {
            if((i != (numsSorted.length - 1)) && (numsSorted[i] == numsSorted[i+1]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(containsDuplicate(nums));
        nums = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));
        nums = new int[]{1,1,1,3,3,4,3,2,4,2};
        System.out.println(containsDuplicate(nums));
    }
}
