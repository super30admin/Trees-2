// Time Complexity : O(n)
// Space Complexity : O(n) height of the tree during the recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    int num =0;
    public int sumNumbers(TreeNode root) {
        sum(root,0);
        return num;
    }
  // using recursion to traverse through the tree from root to leaf
  // add the temporary sum by shifting to the next higher order and once reached the leaf node add to the global variable
    
    public void sum(TreeNode root,int temp){
        if(root == null) return;
        temp = temp*10+root.val;
        if(root.left == null && root.right == null) num += temp;
        if(root.left != null) sum(root.left,temp);
        if(root.right != null) sum(root.right,temp);
    }
}
