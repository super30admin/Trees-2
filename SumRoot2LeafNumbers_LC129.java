// Time Complexity: O(n) – We visit each node once.
// Space Complexity: O(h) – Call stack height, where h is the height of the tree.
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : YES

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
class SumRoot2LeafNumbers_LC129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currSum) {
        if (node == null) return 0;

        currSum = currSum * 10 + node.val;

        // If leaf node, return the formed number
        if (node.left == null && node.right == null) {
            return currSum;
        }

        return dfs(node.right, currSum) + dfs(node.left, currSum);
    }
}