// Problem2 - https://leetcode.com/problems/sum-root-to-leaf-numbers/

// Time Complexity : O(n)
// Space Complexity : O(h) // height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

public class problem2 {
    int result;

    public int sumNumbers(TreeNode root) {
        inorder(root, 0);
        return result;
    }

    private void inorder(TreeNode root, int currSum) {
        // base
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            result += currSum * 10 + root.val;
            ;
        }

        // left
        inorder(root.left, currSum * 10 + root.val);

        // right
        inorder(root.right, currSum * 10 + root.val);

    }
}
