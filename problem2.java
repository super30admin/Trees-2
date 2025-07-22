// Time Complexity: O(n) number of nodes
// Space Complexity: O(H) height of the tree

// we recursively build the number from root to leaf, when we reach a leaf, add that number of globalSum

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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return sum;
    }

    public void traverse(TreeNode root, int currNum) {
        if (root == null) return;

        currNum = currNum * 10 + root.val;

        if (root.left == null && root.right == null) sum = sum + currNum;

        traverse(root.left, currNum);
        traverse(root.right, currNum);
    }
}
