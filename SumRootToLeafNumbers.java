// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        // Update the current sum by adding the current node's value
        currentSum = currentSum * 10 + node.val;

        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }

        // Otherwise, calculate the sum of left and right subtrees
        int leftSum = helper(node.left, currentSum);
        int rightSum = helper(node.right, currentSum);

        return leftSum + rightSum;
    }
}