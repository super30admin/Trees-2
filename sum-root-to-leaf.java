//Time Complexity is O(n)
//Space Complexity is O(h) => logn
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int result = 0;

    public int sumNumbers(TreeNode root) {

        return dfs(root, 0);

    }

    private int dfs(TreeNode root, int num) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return (num * 10 + root.val);
        }

        // recursive call

        return dfs(root.left, num * 10 + root.val)
                + dfs(root.right, num * 10 + root.val);
    }

}