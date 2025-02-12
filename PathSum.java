// Time Complexity : O(n)
// Space Complexity : O(h) recursive stack where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
At each node, calculate the sum
Add the sum only at leaf nodes
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
    int sum;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return sum;
    }

    public void helper(TreeNode node, int curr){
        //base
        if(node==null) return;

        curr=curr*10+node.val;

        if(node.left==null && node.right==null)
            sum+=curr;

        //logic
        helper(node.left,curr);
        helper(node.right,curr);
    }
}