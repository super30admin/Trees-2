// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int curr) {
        if (root == null) return 0;

        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            return curr;
        }

        return helper(root.left, curr) + helper(root.right, curr);
    }
}