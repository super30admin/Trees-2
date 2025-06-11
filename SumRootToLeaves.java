/*
Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/

public class SumRootToLeaves {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int curr) {
        // base
        if (node == null)
            return 0;

        curr = curr * 10 + node.val;

        if (node.left == null && node.right == null) {
            return curr;
        }

        int left = dfs(node.left, curr);
        int right = dfs(node.right, curr);

        return left + right;
    }
}
