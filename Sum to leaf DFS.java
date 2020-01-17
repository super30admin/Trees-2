// Time complexity 0(n)
// space complexity 0(h)
// code successfully executed in leetcode

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
             
             return Numbers(root,0);
        
    }
     public int Numbers(TreeNode root, int val1){
         
         //Base case
         if(root==null) return 0;
         if(root.left == null && root.right == null) return val1*10 + root.val;
          
         // logic 
         return Numbers(root.left, val1*10 + root.val) + Numbers(root.right, val1*10 + root.val);
     }
}