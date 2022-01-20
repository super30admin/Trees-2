// Time Complexity : O(n) where n is number of nodes in binary tree
// Space Complexity : O(h) where h is height of binary tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class SumNumbers {
    public static void main(String[] args) {
        
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] res = new int[1];
        res[0] = 0;
        helper(root, 0, res);
        return res[0];
    }
    private void helper(TreeNode root, int curSum, int[] res){
        //base
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            //leaf node
            res[0] += curSum * 10 + root.val;
        }
        
        //logic
        helper(root.left, curSum * 10 + root.val, res);
        helper(root.right, curSum * 10 + root.val, res);
    }

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
 
}
