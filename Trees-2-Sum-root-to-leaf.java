//Recurrsive Solution

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        
        
        return helper(root,0); //initial sum = 0
        
    }
    public int helper(TreeNode node, int value){
            
            
            //Base case    
        
            if(node == null) return 0;
            if(node.left == null && node.right==null) return value*10 + node.val; //Last node
        
            
            //Add left and right
        
            return helper(node.left, value*10 + node.val) + helper(node.right, value*10 + node.val); 
       
        }
        
        
    
}