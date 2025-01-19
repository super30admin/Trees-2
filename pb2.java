class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }
        
        // Update the current sum by adding the node's value
        currentSum = currentSum * 10 + node.val;
        
        // If the node is a leaf, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Recursively calculate the sum for the left and right children
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        
        // Return the total sum of both subtrees
        return leftSum + rightSum;
    }
}
