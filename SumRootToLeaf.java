// Time Complexity : O(tree)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : start at root and compute integer equivalnt for each branch from root to leaf. Sum them all up into a result variable

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
        //helper(root, 0);
        //return result;
        return helper2(root, 0);
    }
    public int helper2(TreeNode root, int curr){
        if(root==null){
            return 0;
        }
        curr=curr*10+root.val;
        if(root.left==null && root.right==null){
            return curr;
        }
        return helper2(root.left, curr)+helper2(root.right, curr);
    }
    public void helper(TreeNode root, int curr){
        if(root == null){
            return;
        }
        curr = curr*10+root.val;
        if(root.left == null && root.right == null){
            result += curr;
        }
        helper(root.left, curr);
        helper(root.right, curr);
    }
}