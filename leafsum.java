/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 * 
 * TC: O(n)
 * SC: O(1)
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        sum = (sum * 10) + root.val;

        if (root.left == null && root.right == null) return sum;

        int lSum = helper(root.left, sum);

        int rSum = helper(root.right, sum);

        return lSum + rSum;
    }
}