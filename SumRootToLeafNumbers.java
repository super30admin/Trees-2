// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

// Approach - DFS 

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int curr) {

        // When you hit the leaf node then return
        if (root == null) {
            return;
        }

        // Build the digits
        curr = curr * 10 + root.val;

        // If both left and right are null i.e leaf node then add the current sum to
        // global sum
        if (root.left == null && root.right == null) {
            sum += curr;
        }

        // Recursively call left and right subtree.
        helper(root.left, curr);
        helper(root.right, curr);
    }
}