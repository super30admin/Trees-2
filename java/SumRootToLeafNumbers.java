package java;

public class SumRootToLeafNumbers {
    int res;

    public int sumNumbers(TreeNode root) {
        this.res = 0;
        int sum = 0;

        helper(root, 0);
        return res;
    }

    private void helper(TreeNode root, int currSum) {
        //base case
        if (root == null)
            return;

        currSum = currSum * 10 + root.val;

        if (root.left == null && root.right == null)
            res += currSum;

        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}

//TC: O(n)
// SC: O(n) - if skewed tree or O(log n) for balanced tree