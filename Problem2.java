class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        recur(root, 0);
        return sum;
    }

    public void recur(TreeNode root, int currSum) {
        if (root == null)
            return;
        currSum = currSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            sum += currSum;
            return;
        }
        recur(root.left, currSum);
        recur(root.right, currSum);

    }
}