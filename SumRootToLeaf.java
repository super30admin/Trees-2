// Time Complexity O(n)
// Space Complexity O(h)
// Runs on LeetCode: YES

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class SumRootToLeaf {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return result;
    }

    private void inorder(TreeNode root, int sum) {
        if (root == null)
            return;
        sum = (sum * 10) + root.val;
        if (root.left == null && root.right == null) {
            result = result + sum;
        }
        inorder(root.left, sum);
        inorder(root.right, sum);
    }
}
