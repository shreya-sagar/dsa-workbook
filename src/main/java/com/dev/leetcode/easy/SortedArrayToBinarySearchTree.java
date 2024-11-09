package com.dev.leetcode.easy;

import com.dev.leetcode.easy.model.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class SortedArrayToBinarySearchTree {

    /**
     * Working for 1 test case
     * Input: nums = [1,3]
     * Output: [1,null,3]
     * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode(nums[0]);
        if (nums.length == 1)
            return treeNode;

        int counter = 1;
        TreeNode left = null;
        TreeNode right = null;

        while (counter < nums.length) {
            if (counter - 2 >= 0)
                left = new TreeNode(nums[counter - 2], right, left);
            right = new TreeNode(nums[counter], right, null);
            treeNode = new TreeNode(nums[counter - 1], left, right);
            counter++;
        }

        return treeNode;
    }

    /*public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = new TreeNode(nums[0]);
        if (nums.length == 1)
            return treeNode;

        TreeNode left = null;
        TreeNode right = null;
        if (nums.length == 2) {
            right = new TreeNode(nums[1], treeNode, null);
            treeNode = new TreeNode(nums[0], left, right);
        }

        else if (nums.length == 3) {
            // left = new TreeNode(nums[0], null, nums[1]);
            left = treeNode;
            // right = new TreeNode(nums[2], nums[1], null);
            right = new TreeNode(nums[2], right, null);
            treeNode = new TreeNode(nums[1], left, right);
        }

        else {
            int counter = 3;
            while (counter < nums.length) {
                if (counter - 2 >= 0)
                    left = new TreeNode(nums[counter - 2], right, left);
                right = new TreeNode(nums[counter], right, null);
                treeNode = new TreeNode(nums[counter - 1], left, right);
                counter++;
            }
        }

        return treeNode;
    }*/
}
