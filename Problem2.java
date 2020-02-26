// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        returnSum(root, 0);
        return res;

    }

    private void returnSum(TreeNode node, int rSum) {

        if (node.left == null || node.right == null) {
            res += rSum * 10 + node.val;
            return;
        }

        rSum += rSum * 10 + node.val;

        if (node.left != null) {
            returnSum(node.left, rSum);
        }

        if (node.right != null) {
            returnSum(node.right, rSum);
        }

    }
}