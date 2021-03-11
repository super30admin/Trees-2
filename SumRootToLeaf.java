//tc: O(n); n = #nodes
//sc: O(n); bcz of recursion stack
public class SumRootToLeaf {
    int total = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return total;
    }
    private void helper(TreeNode root, int num) {
        if (root != null) {
            num = num * 10 + root.val;

            if (root.left == null && root.right == null) {
                total += num;
            }

            helper(root.left, num);
            helper(root.right, num);
        }
    }
}
