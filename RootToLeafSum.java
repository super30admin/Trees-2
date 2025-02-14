// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Void based recursion

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int curr) {
        if (root == null) return;

        curr = curr * 10 + root.val;
        if (root.left == null && root.right == null) {
            result += curr;
        }

        helper(root.left, curr);
        helper(root.right, curr);
    }
}