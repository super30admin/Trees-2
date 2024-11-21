// Time Complexity : O(n) where n is the number of nodes in the tree
// Space Complexity : O(h) for recursion stack where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class sumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);    
    }
    private int helper(TreeNode root, int value) {
        // base case
        if (root == null) return 0;
        if (root.left == null && root.right == null) return value*10 + root.val;
        // logic
        return helper(root.left, value * 10 + root.val) +
               helper(root.right, value * 10 + root.val);
    }
}