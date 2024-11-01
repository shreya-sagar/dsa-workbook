package com.dev.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class TwoSumOptimized {
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],i);
        }
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i) {
                return new int[]{i, map.get(target - nums[i])};
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
