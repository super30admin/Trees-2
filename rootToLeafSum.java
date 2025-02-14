// Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, current is calculated at each and every node. At the end of the every leaf, the current is returned to respective recursive stack.
 * For left tree, left node and current sum till root are passed and for right tree, right node and current sum till root are passed. The
 * sum of left and right gives the sum from root to leaves of the binary tree.
 */

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
        return helper(root, 0); // 0 is the initial currSum
    }

    private int helper(TreeNode root, int curr){
        if(root == null ) return 0;
        curr = curr*10+root.val;
        if(root.left == null && root.right == null){
            return curr;
        }
        int left = helper(root.left, curr);
        int right= helper(root.right, curr);
        return left+right;
    }
}