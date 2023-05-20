// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree, for the internal 
//     recursion stack
// Did this code successfully run on Leetcode : Yes

/*
 * Approach:
 * We traverse till the leaf of the tree, all the while keeping track of the
 * current "sum", which is the running sum of all the digits in that number,
 * which adds up to the actual element when we reach the leaf. This is then
 * added to the total sum.
 */

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
class Solution {
    int ans;

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // don't start here itself because the traversal will
        // add the sum that we want
        helper(root, 0);
        return ans;
    }

    private void helper(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        // shift the digits to left to make space for this digit
        sum = sum * 10 + root.val;

        // when at the leaf, we're at the end, just go ahead
        // and add to the answer
        if(root.left == null && root.right == null) {
            ans += sum;
            return;
        }
        helper(root.left, sum);
        helper(root.right, sum);
    }
}