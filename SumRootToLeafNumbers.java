// Time Complexity : O(N), worst case
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

public class SumRootToLeafNumbers {
    private int totalSum;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return totalSum;
    }

    private void helper(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        currentSum = (currentSum * 10) + root.val;
        helper(root.left, currentSum);
        if (root.left == null && root.right == null) {
            totalSum += currentSum;
        }
        helper(root.right, currentSum);
    }
}