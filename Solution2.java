// Time Complexity : O(n) touch all nodes
// Space Complexity :O(h) maximum nodes in a recursive stack at one time
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
 // Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    // returning a global variable with recursive helper method
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        helper(root,0);
        return sum;
        
    }
    private void helper (TreeNode root,int currSum){
        if(root==null)
            return;
        
        helper(root.left,currSum*10+root.val);
        helper(root.right,currSum*10+root.val);
        if(root.left==null && root.right==null){
            sum=sum+currSum*10+root.val;
            return;
        }
    }
}