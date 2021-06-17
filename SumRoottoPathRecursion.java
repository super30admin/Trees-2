// Time Complexity : O(n)
// Space Complexity : O(h) h -height of the tree
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

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

 //Recursion

class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
      if(root == null) return 0;
      helper(root,0);
      return result;
    }
    private void helper(TreeNode root, int currSum) {
      
      if(root == null) return;
      currSum = 10 * currSum + root.val;
      helper(root.left, currSum);
      if(root.left == null && root.right == null) {
          result+= currSum;
       }
       helper(root.right, currSum);
      }
}