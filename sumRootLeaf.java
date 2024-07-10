/*
TC --> O(n)
SC --> O(n) auxallary space
 */
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
class Solution {

    public int sumNumbers(TreeNode root) {

        return Helper(root, 0);

    }

    public int Helper(TreeNode root, int val) {
        if (root != null) {

            if (root.left == null && root.right == null) {
                return val * 10 + root.val;
            }

            int left_val = Helper(root.left, val * 10 + root.val);
            int right_val = Helper(root.right, val * 10 + root.val);
            return left_val + right_val;

        }
        return 0;

    }//method
}//class
