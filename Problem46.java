// Time Complexity : O(N)
// Space Complexity : O(h)

class Solution {
    private int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum) {
        //base
        if (root == null) return;

        //logic
        currSum = currSum * 10 + root.val;

        helper(root.left, currSum);
                if (root.left == null && root.right == null) {
            result += currSum;
        }
        helper(root.right, currSum);
    }
}