import java.util.HashMap;

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Maintain result in global scope and process left and right sub tree recursively passing currSum to further nodes
// When ever we find leaf node (ir. left and right child = null) then add the currSum to result
class SumToLeafNode {
    int result;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum) {
        if (root == null)
            return;

        currSum = 10 * currSum + root.val;

        helper(root.left, currSum);

        if (root.left == null && root.right == null) {
            result += currSum;
        }

        helper(root.right, currSum);
    }
}
