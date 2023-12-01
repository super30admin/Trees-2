// Time Complexity :O(N), number of nodes
// Space Complexity :O(H), height of tree
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
       return helper(root,0);
    }

    public int helper(TreeNode root,int sum)
    {
        if(root == null)
         return 0;
        int currentsum =sum*10+root.val;
        
        if(root.left==null && root.right == null)
          return currentsum;

       int left=helper(root.left,sum*10+root.val);
       int right= helper(root.right,sum*10+root.val);

       return left+right;
    }
}