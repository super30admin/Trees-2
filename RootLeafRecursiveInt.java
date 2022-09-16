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
//tc-o(n)
//sc-o(h)
class Solution {
    int result =0;
    public int sumNumbers(TreeNode root) {
       
        return helper(root,0);
        //return result;
        
    }
    private int helper(TreeNode root, int currnum)
    {
        if(root==null) return 0;
        
        currnum = currnum*10+root.val;
        if(root.right == null && root.left == null)
        {
            return currnum;
        } 
              
        int leftsum = helper(root.left,currnum);
       int rightsum = helper(root.right,currnum);
        
        return leftsum+rightsum;
        
        
    }
}