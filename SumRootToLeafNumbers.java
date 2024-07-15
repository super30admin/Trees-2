// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
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
    // void based recursion
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currentNum) {
        if(root == null) return;

        currentNum = currentNum * 10 + root.val;
        if(root.left == null && root.right == null) {
        result+= currentNum;
        }
        // logic
        // left tree
        helper(root.left, currentNum);
        // right tree
        helper(root.right, currentNum);
    }
}