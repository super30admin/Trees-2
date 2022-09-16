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
    int result =0;
    public int sumNumbers(TreeNode root) {
       
        helper(root,0);
        return result;
        
    }
    private void helper(TreeNode root, int currnum)
    {
        if(root==null) return;
        
        if(root.right == null && root.left == null)
        {
            result += currnum*10+root.val;
        }
        
        System.out.print(root.val + " ");
        System.out.println(currnum);
        
        
        
        helper(root.left,currnum*10+root.val);
        helper(root.right,currnum*10+root.val);
        
        
    }

    private void helper(TreeNode root, int currnum)
    {
        if(root==null) return;
        
        if(root.right == null && root.left == null)
        {
            result += currnum*10+root.val;
        }
   
        currnum = currnum*10+root.val;
        helper(root.left,currnum);
        helper(root.right,currnum);
        
        
    }
}