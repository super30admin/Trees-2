// Time Complexity : O()
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class RootToLeafNum {

  //Definition for a binary tree node.

    class TreeNode {
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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    
    private void helper(TreeNode root, int currNum){
        //base case
        if(root == null)
            return;
        helper(root.left,currNum*10 + root.val);
        if(root.left == null && root.right == null)
        {
            result += currNum * 10 + root.val;
        }
        helper(root.right,currNum * 10 + root.val);
    }
}
