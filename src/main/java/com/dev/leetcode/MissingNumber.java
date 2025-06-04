package com.dev.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int n = nums.length;
        int missing = 0;
        HashMap<Integer, Boolean> numsMap = new HashMap<>();
        for(int i = 0 ; i <= n; i++) {
            numsMap.put(i, false);
        }
        System.out.println(numsMap);
        for(int num : nums) {
            numsMap.put(num, true);
        }
        System.out.println(numsMap);
        for(Map.Entry<Integer, Boolean> entry : numsMap.entrySet()) {
            System.out.println(entry.getValue());
            System.out.println(entry.getKey());
            if(entry.getValue().equals(false)) {
                missing = entry.getKey();
                return missing;
            }
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(missingNumber(nums));

    }
}
