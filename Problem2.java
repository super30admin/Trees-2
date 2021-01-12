//https://leetcode.com/problems/sum-root-to-leaf-numbers/
// Time complexity : O(N)
// Space complexity : O(1)
// Did this code successfully run on Leetcode : YES
class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int runningSum) {
        if (root == null)
            return;

        runningSum = (runningSum * 10) + root.val;
        if (root.left == null && root.right == null) {
            sum += runningSum;
            return;
        }

        helper(root.left, runningSum);
        helper(root.right, runningSum);

    }

}