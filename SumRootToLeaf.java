
//Time Complexity -  O(n) where n is the number of nodes
//Space Complexity - O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// We go through all the paths , we maintain a global result and local current sum variable
// when we go to the next level in the same path, we compute currentsum and add it to the result variable.

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
    private int result;
    public int sumNumbers(TreeNode root) {
        result=0;
        int currentsum=0;
        helper(root,currentsum);
        return result;
    }
    public void helper(TreeNode root, int currentsum){
       
        if(root==null) return;
        if(root.left== null && root.right==null){
            currentsum=(currentsum*10)+root.val;
             result+=currentsum;
            return;
        }
        
        currentsum = currentsum*10+root.val;
        helper(root.left,currentsum);
         
        
        helper(root.right,currentsum);
    }
}