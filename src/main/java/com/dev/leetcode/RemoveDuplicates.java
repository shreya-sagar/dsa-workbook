package com.dev.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        System.out.println("nums " + Arrays.toString(nums));
        int[] newNums = new int[nums.length];
        newNums[0] = nums[0];
        int unique=1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] != nums[i-1])
                newNums[unique++] = nums[i];
        }
        for (int i = 0; i < unique; i++) {
            nums[i] = newNums[i];
        }
        System.out.println("Changed nums " + Arrays.toString(nums));
        //nums = Arrays.copyOf(newNums, unique);
        return unique;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicates(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
    }
}
