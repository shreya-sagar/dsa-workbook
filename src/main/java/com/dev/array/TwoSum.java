package com.dev.array;

import java.util.Arrays;
import java.util.Scanner;

public class TwoSum {
    /**
     * Source : Leetcode
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Example :
     * Input: nums = [2,7,11,15], target = 9 Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * Constraints:
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * Only one valid answer exists.
     */
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0; i < nums.length; i++) {
            for(int j=i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter length of array : ");
        int length = scanner.nextInt();

        System.out.println("Enter elements of array");
        int[] nums = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.print("Element" + (i+1) + " : ");
            nums[i] = scanner.nextInt();
        }
        System.out.print("Enter target : ");
        int target = scanner.nextInt();
        scanner.close();

        int[] indices = twoSum(nums,target);
        System.out.println("Indices : " + Arrays.toString(indices));
    }
}
