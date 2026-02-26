// O(n) time, O(n) space
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currSum) {
        if (root == null) return 0;

        currSum = currSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }
        int left = helper(root.left, currSum);
        int right = helper(root.right, currSum);

        return left + right;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}