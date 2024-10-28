package com.dev.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TwoSumTest {

    @Test
    void twoSum() {
        int nums[] = {2,7,11,15};
        int target = 13;
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, TwoSum.twoSum(nums,target));
    }

    @Test
    void twoSumOptimized() {
        int nums[] = {2,7,11,15};
        int target = 13;
        int[] expected = {0, 2};
        Assertions.assertArrayEquals(expected, TwoSumOptimized.twoSum(nums,target));
    }

    @Test
    void twoSumWithNoSolution() {
        int nums[] = {2,7,11,15};
        int target = 20;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, TwoSum.twoSum(nums,target));
    }

    @Test
    void twoSumOptimizedWithNoSolution() {
        int nums[] = {2,7,11,15};
        int target = 20;
        int[] expected = {};
        Assertions.assertArrayEquals(expected, TwoSumOptimized.twoSum(nums,target));
    }
}