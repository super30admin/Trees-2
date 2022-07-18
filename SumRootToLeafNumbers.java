import javax.swing.tree.TreeNode;

// Time Complexity : O(n)
// Space Complexity : O(h), where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

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
class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return sum;

        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        // base
        if (root == null)
            return;

        // logic
        if (root.left == null && root.right == null) { // checking for a leaf node
            sum = sum + (num * 10) + root.val;
        }
        helper(root.left, (num * 10) + root.val);
        helper(root.right, (num * 10) + root.val);

    }
}