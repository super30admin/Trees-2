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
// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes

class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, root.val);
        return sum;
    }

    // DFS
    private void dfs(TreeNode root, int currentSum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sum += currentSum;
            return;
        }
        // LeftRecursiveCall
        if (root.left != null) {
            dfs(root.left, currentSum * 10 + root.left.val);
        }
        // RightRecursiveCall
        if (root.right != null) {
            dfs(root.right, currentSum * 10 + root.right.val);
        }
    }
}