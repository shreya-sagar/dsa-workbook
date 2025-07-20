package com.dev.algorithms.sort;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] nums, String sortType) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(sortType.equals("ASC")) {
                    if(nums[j] > nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                } else if (sortType.equals("DESC")) {
                    if(nums[j] < nums[j+1]) {
                        int temp = nums[j];
                        nums[j] = nums[j+1];
                        nums[j+1] = temp;
                    }
                }

            }
        }
        return nums;
    }

    //chatgpt
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // Optimization: break if no swaps
            if (!swapped) break;
        }
    }


    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        System.out.println(Arrays.toString(bubbleSort(arr, "ASC")));
        System.out.println(Arrays.toString(bubbleSort(arr, "DESC")));
    }
}
