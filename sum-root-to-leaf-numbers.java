// Time Complexity :
O(no.of nodes in the tree)
// Space Complexity :
recursiive stack space would be O(height of the tree)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


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
        
        if(root == null) return 0;
        
        //call helper function
       return helper(root,0);
        
        
         }
    
    private int helper(TreeNode root, int currentSum){
        //base condition
        if(root == null) return 0;
        //logic
        if(root.left == null && root.right == null){
            return currentSum * 10 + root.val;
        }
        //else I have to recurse through left subtree and right subtree
        int leftSum = helper(root.left, currentSum*10 + root.val);
        int rightSum = helper(root.right, currentSum*10 + root.val);
        return leftSum + rightSum;
    }
}