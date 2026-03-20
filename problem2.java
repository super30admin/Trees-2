    /**
    Time Complexity : O(N)
    Explanation:
    We traverse each node once using DFS.

    Space Complexity : O(H)
    Explanation:
    Recursion stack depends on height of the tree.
    Worst case (skewed tree) → O(N), balanced → O(log N).

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially confused about how to carry the number formed
    from root to current node.
    Fixed it by passing the accumulated sum in recursion:
        sum = sum * 10 + current node value
    and adding it to result when a leaf node is reached.
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


    int result;

    public int sumNumbers(TreeNode root) {

        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {

        if (root == null) return;

        // Build number from root to current node
        sum = sum * 10 + root.val;

        // If leaf node, add to result
        if (root.left == null && root.right == null) {
            result += sum;
            return;
        }

        helper(root.left, sum);
        helper(root.right, sum);
    }
}