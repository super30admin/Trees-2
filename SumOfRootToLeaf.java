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

// Time complexity - O(n)
 //Space compplexity - O(1)
 // did you face any issues- no
 // Solved on leetcode - yes
 // If we are at the leaf node, we simply return the value of the node, else we will be updating the 
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int current) {
        // base
        if(root == null) return 0;
        current = current *10 + root.val;

        if(root.left == null && root.right == null) return current;

        int leftSum = helper(root.left, current);
        int rightSum = helper(root.right, current);
        return leftSum+rightSum;
    }
}
