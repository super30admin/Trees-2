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

// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Traverse through all the nodes recursively in preorder. Calculate the sum at every stage. If the node is a left node, then add the
 * sum to the result.
 */
class Solution {

    int result = 0;
    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {

        if(root == null) return;

        sum = (sum*10) + root.val;
        if(root.left == null && root.right == null)
            result += sum;

        helper(root.left, sum);
        helper(root.right, sum);
    }
}