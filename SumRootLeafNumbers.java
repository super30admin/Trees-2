// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    if(root == null) return 0;
    helper(root, 0);
    return sum;
  }

  void helper(TreeNode root, int currentSum) {
    if(root == null) return;
    if(root.left==null && root.right==null) {
      sum += currentSum*10 + root.val;
      return;
    }
    helper(root.left, currentSum*10+root.val);
    helper(root.right, currentSum*10+root.val);
  }
}