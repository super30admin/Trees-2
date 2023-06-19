class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return sum;
    }

    private void helper(TreeNode root, int currSum) {
        if (root == null) {
            return;
        }
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}