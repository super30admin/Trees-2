// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    public int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,String.valueOf(root.val));
        return sum;
    }
    public void helper(TreeNode root,String s){
        if(root.left==null && root.right==null){
            sum += Integer.valueOf(s);
            return;
        }
        if(root.left!=null){
            helper(root.left,s+String.valueOf(root.left.val)); 
        }
        if(root.right!=null){
            helper(root.right,s+String.valueOf(root.right.val));
        }
    }
}