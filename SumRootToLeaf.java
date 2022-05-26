// https://leetcode.com/problems/sum-root-to-leaf-numbers/

// Time Complexity :O(n) 
// Space Complexity :O(h) h=height of the tree
// Did this code successfully run on Leetcode : yes
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
    public int sum=0;
    public int sumNumbers(TreeNode root) {
        postorderhelper(root,0);
        return sum;
    }
    private void inorderhelper(TreeNode root,int lsum)
    {
        if(root==null)
            return;
        if(root.left==null && root.right==null)
        {
            sum+=lsum*10+root.val;
        }
        inorderhelper(root.left,lsum*10+root.val);
        inorderhelper(root.right,lsum*10+root.val);
    }
    private void preorderhelper(TreeNode root,int lsum)
    {
        if(root==null)
            return;
         preorderhelper(root.left,lsum*10+root.val);
        if(root.left==null && root.right==null)
        {
            sum+=lsum*10+root.val;
        }
       
        preorderhelper(root.right,lsum*10+root.val);
    }
    private void postorderhelper(TreeNode root,int lsum)
    {
        if(root==null)
            return;
         postorderhelper(root.left,lsum*10+root.val);
       
       
        postorderhelper(root.right,lsum*10+root.val);
         if(root.left==null && root.right==null)
        {
            sum+=lsum*10+root.val;
        }
    }
}