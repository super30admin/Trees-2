
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class RootToLeafSum {

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        return helper(root, 0);

    }

    private int helper(TreeNode root, int num) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}

// TC: O(n) SC: O(1)
