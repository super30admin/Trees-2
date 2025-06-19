/*
 * Given a binary tree, return the sum of all root-to-leaf numbers.
 * Approach:
 * 1. Use Depth First Search (DFS) to traverse the tree.
 * 2. Maintain a current sum that represents the number formed from the root to the current node.
 * 3. When a leaf node is reached, add the current sum to the total sum. 
 * 4. Recursively calculate the sum for both left and right subtrees.
 * 
 * * Time Complexity: O(n), where n is the number of nodes in the tree.
 * * Space Complexity: O(h), where h is the height of the tree (due to recursion stack).
 */
public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        if (node == null) return 0;

        currentSum = currentSum * 10 + node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
    }

}