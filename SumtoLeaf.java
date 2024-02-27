// Time Complexity : O(n) , n for traversing over the nodes 
// Space Complexity : O(h) where h = height of the tree (max recursion calls at one point)
// Did this code successfully run on Leetcode : yes
// Three line explanation of solution in plain english : Pass value from left + right subtree to parent, and at leaf node add it to sum 

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
        return helper(root,0);
    }

    private int helper(TreeNode root,int currSum){
        //base
        if(root == null) return 0;
        //logic
        int value = currSum * 10 + root.val;
        //at leaf node.
        if(root.left == null && root.right == null){
           return value;
        }

        
        return helper(root.left,value) + helper(root.right,value);
    }
}