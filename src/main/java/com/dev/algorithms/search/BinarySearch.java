package com.dev.algorithms.search;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while(low <= high) {
            int mid = (low + high)/2;
            if(nums[mid] == target) return mid;
            if(target > nums[mid]) low = mid + 1;
            if(target < nums[mid]) high = mid - 1;
        }
        return -1;
    }
}
