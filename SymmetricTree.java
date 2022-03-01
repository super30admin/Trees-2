// Time Complexity : O(n)
// Space Complexity : O(n)
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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root,root);
    }
    
    public boolean isMirror(TreeNode tree1, TreeNode tree2) {
        if(tree1 ==null && tree2 == null) {
            //both are null
            return true;
        }
        
        if(tree1 == null || tree2 == null) {
            //one of them is null
            return false;
        }
        
        //both are non null
        //compare and move on to left and right parts
        return (tree1.val == tree2.val) &&
            isMirror(tree1.left, tree2.right) &&
            isMirror(tree1.right, tree2.left);
        
    }
}