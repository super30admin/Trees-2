// Time Complexity : O(n)
// Space Complexity : O(h) h is height of recursive stack
// Did this code successfully run on Leetcode : Yes

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
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        int sum = 0;
        helper(root, sum);
        return result;
    }
    private void helper(TreeNode root, int sum){
        if(root == null)
            return;
        
        sum = sum * 10 + root.val;
        if(root.left == null && root.right == null) {
            result += sum;
        }
        
        helper(root.left, sum);
        helper(root.right, sum);
        return;
    }
}