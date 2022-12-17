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

// Time Complexity : O(h), worst case- skewd tree -> o(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
/*
 * create a global variable gor total sum, and local variable for curentsum at
 * every node, since we need to get the previous node sum value for next node.
 * Followed inorder traversal of the tree. Adding the currSum to total only if
 * we have reached the leaf node.
 */
class Solution {
    private int totalSum;

    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return totalSum;
    }

    private void helper(TreeNode root, int currSum) {
        // base
        if (root == null)
            return;

        // increment currSum for every root val
        currSum = (currSum * 10) + root.val;

        // logic
        // left recurssive call
        helper(root.left, currSum);

        // add the total sum only when we reach child node
        if (root.left == null && root.right == null) {
            totalSum += currSum;
        }
        // right recurssive call
        helper(root.right, currSum);
    }
}