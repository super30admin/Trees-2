/**
 * Time Complexity: O(n)
 * Space complexity: O(h); height of the tree
 * Ran on leetcode? Yes
 * Problems faced? No
 *
 * Approach:
 * Upon doing a depth first search we are able to create the number
 * that needs to be summed and once the leaf node is reached sum it with the old number
 */
public class SumRootLeaf {
    public static class TreeNode {
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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode root, int curSum) {
        if (root == null) {
            return;
        }

        curSum = curSum + root.val;
        dfs(root.left, curSum);
        dfs(root.right, curSum);
        if(root.left == null && root.right == null) {
            sum += curSum;
            return;
        }
    }
}
