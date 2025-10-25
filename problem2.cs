/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    public int SumNumbers(TreeNode root) {     
        int result=0; 
        helper(root,0,ref result);
        return result;     
    }
    void helper(TreeNode root,int currentValue,ref int result)
    {
        if(root == null) return;
        
        currentValue = root.val + currentValue * 10;

        if(root.left == null && root.right == null)
        {
            result = result+currentValue;
        }
        helper(root.left,currentValue,ref result);
        helper(root.right,currentValue,ref result);
    }

}