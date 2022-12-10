/**
 * Leetcode129
 */
public class Leetcode129 {

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

    int sum;

    public int sumNumbers(TreeNode root) {
        // this we are doing with recursive method:
        if (root == null)
            return 0;
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int num) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            sum += num * 10 + root.val;
        }
        // left call
        dfs(root.left, num * 10 + root.val);
        // right call
        dfs(root.right, num * 10 + root.val);
    }
}

// tc--> O(n)
// sc--> O(h)--> height of tree