// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//129. Sum Root to Leaf Numbers
//https://leetcode.com/problems/sum-root-to-leaf-numbers/

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

public class Problem2 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curr) {
        // base
        if (root == null)
            return;

        // logic
        helper(root.left, (curr * 10 + root.val));
        if (root.left == null && root.right == null)
            sum += (curr * 10 + root.val);

        helper(root.right, (curr * 10 + root.val));
    }
}
