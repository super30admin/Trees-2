public class Sum {
    // TC O(N)
    // SC O(h) -> h is the height of the tree(recursive stack)
    public class TreeNode {
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

    int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return sum;
        }
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int num) {
        if (root == null) {
            return;
        }
        num = num * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += num;
            // return;
        }

        helper(root.left, num);
        helper(root.right, num);

    }
}
