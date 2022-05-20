public class SumRoot2Leaf {
  int result = 0;

  public int sumNumbers(TreeNode root) {
    helper(root, 0);
    return result;
  }

  private void helper(TreeNode root, int sum) {
    if (root == null)
      return;
    sum = sum * 10 + root.val;
    if (root.left == null && root.right == null) {
      result += sum;
    }
    helper(root.left, sum);
    helper(root.right, sum);
    sum = sum / 10;
  }
}
