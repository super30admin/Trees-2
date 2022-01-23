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
    // Time Complexity : O(n), where n is no of nodes in the tree
    // Space Complexity : O(h), where h is the height of the tree
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return sum;
    }

    public void sumNumbersHelper(TreeNode root, int currSum) {
        if(root == null) {
            return;
        }

        sumNumbersHelper(root.left, currSum*10 + root.val);
        sumNumbersHelper(root.right, currSum*10 + root.val);
        if(root.left == null && root.right == null) {
            sum += currSum * 10 + root.val;
        }
    }
}