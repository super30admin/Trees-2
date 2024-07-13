/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Time Complexity: O(n), number of nodes
//Space Complexity: O(h), height of the tree

class Solution {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    
    private int dfs(TreeNode node, int currentSum) {
        // base case: if the current node is null, return 0
        if (node == null) {
            return 0;
        }
        
        // update the current sum by multiplying it by 10 and adding the value of the current node
        currentSum = currentSum * 10 + node.val;
        
        // if the current node is a leaf node (i.e., it has no left or right child), return the current sum
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        // if the current node is not a leaf node, recursively compute the sum of all root-to-leaf paths from its left and right children
        int leftSum = dfs(node.left, currentSum);
        int rightSum = dfs(node.right, currentSum);
        
        // return the sum of the results from the left and right subtrees
        return leftSum + rightSum;
    }
}
