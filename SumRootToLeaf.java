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

/**
 use recussion
 TC: O(n)
 SC: O(h) -> height of tree
 */
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;
        preorder(root, 0);
        return sum;
    }

    private void preorder(TreeNode root, int currSum) {
        if (root == null) {
            return;
        }

        currSum = currSum * 10 + root.val; // remember this is outside the below if

        if (root.left == null && root.right == null) {
            sum += currSum;
        }
        preorder(root.left, currSum);
        preorder(root.right, currSum);
    }
}
