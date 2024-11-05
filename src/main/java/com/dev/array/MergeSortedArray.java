package com.dev.array;

public class MergeSortedArray {

    //TODO Draft Sketch - Need to Complete the method

    /**
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
     * and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
     * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
     * and the last n elements are set to 0 and should be ignored.
     * nums2 has a length of n.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0 & n > 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
        }

        if (m > 0 && n > 0) {
            int[] mergeArray = new int[nums1.length];
            int index1 = 0;
            int index2 = 0;
            int mergeIndex = 0;
            int small = Math.min(n, m);

            if (small == m) {
                while (index1 < small && index2 < n) {
                    if (nums1[index1] <= nums2[index2]) {
                        mergeArray[mergeIndex] = nums1[index1];
                        index1++;
                        mergeIndex++;
                    } else {
                        mergeArray[mergeIndex] = nums2[index2];
                        index2++;
                        mergeIndex++;
                    }
                }
            } else {
                while (index2 < small && index1 < m) {
                    if (nums1[index1] <= nums2[index2]) {
                        mergeArray[mergeIndex] = nums1[index1];
                        index1++;
                        mergeIndex++;
                    } else {
                        mergeArray[mergeIndex] = nums2[index2];
                        index2++;
                        mergeIndex++;
                    }
                }
            }

            if (index1 < m) {
                for (int i = index1; i < m; i++) {
                    mergeArray[mergeIndex] = nums1[i];
                    mergeIndex++;
                }
            }

            if (index2 < n) {
                for (int i = index2; i < n; i++) {
                    mergeArray[mergeIndex] = nums2[i];
                    mergeIndex++;
                }
            }

            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = mergeArray[i];
            }
        }
    }

    public static void main(String[] args) {

    }
}
