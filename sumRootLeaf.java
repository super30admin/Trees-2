// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

// Your code here  with comments explaining your approach

class Solution {
    int result;

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return result;
        helper(0, root);
        return result;
    }

    private void helper(int sum, TreeNode root) {
        if (root == null)
            return;

        // find the running sum to the current root
        int currsum = sum * 10 + root.val;

        // call in the left and right subtree
        helper(currsum, root.left);
        helper(currsum, root.right);

        // when the left and right subtree are null add the value to result
        if (root.left == null && root.right == null) {
            result += currsum;
        }

    }
}