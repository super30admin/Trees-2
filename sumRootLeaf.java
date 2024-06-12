// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no





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
    public int sumNumbers(TreeNode root) {
        return helper(root , 0);
    }
    private int helper(TreeNode root, int currSum){
        if(root == null)return 0;
        
        if(root.right == null && root.left == null){
            return currSum*10 + root.val;
        }
        
        return helper(root.left,currSum*10 + root.val)+helper(root.right,currSum*10 + root.val);
    }
}