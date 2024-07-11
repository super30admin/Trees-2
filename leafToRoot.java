// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


class Solution {
    // Helper method to traverse the tree and calculate the sum of numbers formed from root to leaf
    private int helper(TreeNode root, Integer current) {
        // Base case: If the current node is null, return 0
        if (root == null) return 0;

        // Update the current number by appending the current node's value
        current = current * 10 + root.val;

        // If the current node is a leaf node, return the current number
        if (root.left == null && root.right == null) {
            return current;
        }

        // Recursively call the helper method for the left and right children
        // Sum the values returned from the left and right subtrees
        return helper(root.left, current) + helper(root.right, current);
    }

    // Public method to initiate the process and return the final result
    public int sumNumbers(TreeNode root) {
        // Call the helper method with the root node and the initial current number as 0
        // Return the final sum of all root-to-leaf numbers
        return helper(root, 0);
    }
}
