// Time Complexity : O(h)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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
 
public class SumRootLeafNumbers {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return total;
    }

    public void inorder(TreeNode root, int currNum){
        if (root == null) return;
        currNum = currNum*10 + root.val;

        inorder(root.left, currNum);
        if (root.left == null && root.right == null){
            total = total + currNum;
        }
        inorder(root.right, currNum);
    }
}