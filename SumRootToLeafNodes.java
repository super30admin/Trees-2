// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to learn the concepts

/*
 * Using recurssion:
 * Properties of a leaf node - both left & right nodes are null but root has the value.
 * 
 * calculate the current sum at each node ; 
 * when at root node either return the current sum or add the current sum to the result
 * when not at root node, go left & right with the current sum.
 */

public class SumRootToLeafNodes {

    public int sumNumbers(TreeNode root) {

        return helper(root, 0);
    }

    private int helper(TreeNode root, int currSum) {
        // Base case:
        if (root == null)
            return 0;

        // logic
        currSum = currSum * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currSum;
        }

        return helper(root.left, currSum) + helper(root.right, currSum);
    }

    int result = 0;

    private void helper2(TreeNode root, int currentSum) {
        // base case
        if (root == null)
            return;

        // logic
        currentSum = currentSum * 10 + root.val;

        if (root.left == null && root.right == null) { // leaf node has left as null & right as null
            this.result += currentSum;
            return;
        }

        helper2(root.left, currentSum);
        helper2(root.right, currentSum);

    }
}