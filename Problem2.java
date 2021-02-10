// Time: O(n)
// Space: O(maximum depth)

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
  private int output = 0;
    public int sumNumbers(TreeNode root) {
      int currSum = 0;
       sum(root,0);
      return output;
        
    }
  private void sum(TreeNode root, int currSum){
    if(root == null){
      return ;
    }
     currSum = currSum * 10 + root.val;
    if(root.left == null && root.right == null){
      output += currSum;
      return;
    }
   
    // left recursion
     sum(root.left,currSum);
    
    //right recursion
     sum(root.right,currSum);
    
   
  }
}
