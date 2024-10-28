// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    public int SumNumbers(TreeNode root) {
        return DFS(root, 0);  // Start DFS with initial sum as 0
    }
    
    private int DFS(TreeNode node, int currentSum) {
        if (node == null) return 0;  // Base case: if node is null, return 0

        // Update current number by appending the node's value
        currentSum = currentSum * 10 + node.val;
        
        // If it's a leaf node, return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // Otherwise, recursively calculate the sum for left and right children
        int leftSum = DFS(node.left, currentSum);
        int rightSum = DFS(node.right, currentSum);
        
        // Return the total sum from both subtrees
        return leftSum + rightSum;
    }
}