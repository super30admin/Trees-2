// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// Perform a DFS traversal of the tree, carrying the current number formed along the path.
// At each node, update the number as current * 10 + node.val.
// When a leaf node is reached, return the number; sum the results from left and right subtrees to get the total.

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
class Solution {
    public int sumNumbers(TreeNode root) {
        int total =0;
        return helper(root,total);
    }
    public int helper(TreeNode root, int total){
        if (root == null){
            return 0;
        }

        total = total*10 + root.val;
        if (root.left == null && root.right==null){
            return total;
        }
        int left = helper(root.left,total);
        int right = helper(root.right,total);
        return left+right;
    }
}