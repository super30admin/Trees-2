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
 
    
   /**
    *
    * Procedure: From root => 
    *    1. Do DFS on the left till leaf, carrying the sum forward.
    *    2. Add to a global sum when returning from leaf.
    *    3. Repeat on right.
    * 
    * Time complexity : O(no.of nodes in the tree) -> Because we've to visit every node once for calculating the sum.
    * Space complexity : O(height of the tree) -> At most no of nodes in the tree on recursive stack will height of the tree.
    *
    */  
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return -1;
        
        return rootToLeafSum(root, 0);       
        
    }
    
    
    private int rootToLeafSum(TreeNode node, int sumInCurrentPath) {
        
        if(node == null) return sumInCurrentPath;
        
        // if Node is non leaf shift the exisiting number to the 10's place towards left and add node's value to newSum.
        // Ex: if sum = 15 and current node value is 6.
        // New number = 15 * 10 + 6 == 156
        
        sumInCurrentPath = sumInCurrentPath*10 + node.val;
        
        
        // If node is leaf, return the sum caluculated till this point to parent.
        if(node.left == null && node.right == null) {
            return sumInCurrentPath;
        }
        
        // If non leaf, get sum from left and right branches and return the sum to the parent.
        
        
        // Explicit hack for 1,0 case where we should not return 11.
        int left = 0, right = 0;
        
        if(node.left != null)
            left = rootToLeafSum(node.left, sumInCurrentPath);
        
        if(node.right != null)
            right = rootToLeafSum(node.right, sumInCurrentPath);
        
        return  left + right;
        
    }
    
}
