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
    * https://leetcode.com/problems/sum-root-to-leaf-numbers/
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
    
    private int globalSum;
    
    public int sumNumbers(TreeNode root) {
        if(root == null) return -1;
        
        rootToLeafSum(root, 0);       
        return globalSum; 
    }
    
    
    private void rootToLeafSum(TreeNode node, int sumInCurrentPath) {
        
        if(node == null) return;
        
        // if Node is non leaf shift the exisiting number to the 10's place towards left and add node's value to newSum.
        // Ex: if sum = 15 and current node value is 6.
        // New number = 15 * 10 + 6 == 156
        
        sumInCurrentPath = sumInCurrentPath*10 + node.val;
        
        
        // incase the node is leaf, we've to return.
        if(node.left == null && node.right == null) {
            
            globalSum = globalSum + sumInCurrentPath;
            return;
        }
        
        
        rootToLeafSum(node.left, sumInCurrentPath);
        rootToLeafSum(node.right, sumInCurrentPath);    
    }
    
}
