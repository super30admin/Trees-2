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
 */

 // Approach: Recursion with Preorder
 // Time: O(N); N = number of nodes
 // Space: O(h); h = height of the tree
 class Solution {

    int result;

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum) {

        // base
        if (root == null) {
            return;
        }

        // logic
        currNum = currNum * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += currNum;
            return;
        }

        // recurse
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}