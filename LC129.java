//Time Complexity : O(N)
//Space Complexity : O(1)

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
    
    int sum;
    
    public int sumNumbers(TreeNode root)
    {
        
        if(root==null)
        {
            return 0;
        }
        
        helper(root,0);
        return sum;
        
    }
    
    private void helper(TreeNode root,int num)
    {
        if(root==null)
        {
            return;
        }
        
        num = num*10 + root.val;
        
        helper(root.left,num);
        
        if(root.left==null && root.right==null)
        {
            sum = sum + num;    
        }

        helper(root.right,num);
        
        return;
    }
}