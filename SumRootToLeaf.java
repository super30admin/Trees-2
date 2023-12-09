// Time Complexity : O(n) //recursion
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : -
//
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

//Use recursion to calculate sum of left and right branches. For every leaf node, save the sum in global variable
class SumRootToLeaf {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    private int helper(TreeNode root, int prev){
        if(root == null)
            return 0;

        if(root.left == null && root.right == null)
            return prev*10 + root.val;

        int left = helper(root.left, prev*10+root.val);
        int right = helper(root.right, prev*10+root.val);

        return left + right;
    }
}