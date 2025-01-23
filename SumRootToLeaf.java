/**
 * Time complexity: O(n)
 * Space complexity: O(h) - recursive stack
 */

public class SumRootToLeaf {

  int totalSum = 0;

  public int sumNumbers(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper(root, 0);
    return totalSum;
  }

  private void helper(TreeNode root, int currSum) {
    if (root == null) {
      return;
    }
    if (root.left == null && root.right == null) {
      totalSum += currSum * 10 + root.val;
      return;
    }
    helper(root.left, currSum * 10 + root.val);
    helper(root.right, currSum * 10 + root.val);
  }

  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
