package com.dev.leetcode.easy;

public class SearchInsertPosition {
    /**
     * Given a sorted array of distinct integers and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * You must write an algorithm with O(log n) runtime complexity.
     */
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int desiredIndex = 0;

        if(target < nums[start])
            return start;
        if(target == nums[start])
            return start;
        if(target == nums[end])
            return end;
        if(target > nums[end])
            return end + 1;

        while (start <= end) {
            int mid = (start + end)/2;
            if(target == nums[mid])
                return mid;
            if(target < nums[mid]) {
                end = mid - 1;
                desiredIndex = mid;
            }
            if(target > nums[mid]) {
                start = mid + 1;
            }
        }
        return desiredIndex;
    }
}
