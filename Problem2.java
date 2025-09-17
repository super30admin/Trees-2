// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using dfs to traverse through the tree. Where node's left and right children are null, adding the current sum to the global sum.
 */
class Solution {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return sum;
    }

    private void dfs(TreeNode node, int previous) {
        if (node == null)
            return;

        int currentSum = previous * 10 + node.val;
        // leaf node
        if (node.left == null && node.right == null) {
            sum += currentSum;
        }
        dfs(node.left, currentSum);
        dfs(node.right, currentSum);
    }
}