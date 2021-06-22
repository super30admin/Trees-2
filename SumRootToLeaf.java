// Time Complexity : O(n)
// Space Complexity : O(h) h - height of the tree

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
    int res;
    
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
   private int helper(TreeNode root,int curSum){
       //base
        if(root == null)
            return 0;
        curSum = curSum * 10 + root.val;
        if(root.left == null && root.right == null)
            return curSum;
        //sum of result from left and right subtree 
        return helper(root.left,curSum) + helper(root.right,curSum);
    }
}