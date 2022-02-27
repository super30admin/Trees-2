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
 
 root = [4,9,0,5,1]
 
        4
    9      0
  5   1 
 
 sum = 0;
 
 TC - O(N)
 SC - O(N)
 
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        
        return sumNumberHelper(root, 0);
    }
    
    private int sumNumberHelper(TreeNode root, int sum)
    { 
        
        if (root == null)
        {
            return 0;
        }
        
        // perform operation
        int newSum = sum * 10 + root.val; 
        
        if (root.left == null && root.right == null)
        {
            return newSum;
        }
        
        // traverse left
        int leftSum = sumNumberHelper(root.left, newSum);
        
        // traverse right
        int rightSum = sumNumberHelper(root.right, newSum);
        
        return leftSum + rightSum;
    }
}
