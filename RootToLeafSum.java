// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    int sum;
    public int sumNumbers(TreeNode root) {
        
        
        if(root==null) return sum;
        
        
        helper(root,0);
        
        return sum;
        
    }   
        
        private void helper(TreeNode root, int num)
        {
            
            
            //basecase 
            if(root==null) return;
            
            helper(root.left,num*10+root.val);
          
             if(root.left==null && root.right==null){
                 sum=sum+num*10+root.val;
            return;
        }
          helper(root.right,num*10+root.val);
    }
}