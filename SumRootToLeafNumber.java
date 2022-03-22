// Time Complexity : O(n)
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Take a global variable sum
// Create a recursive function that would take num and treenode
// Run this similar to preorder, and add root's value to 10 * num
// Write exit conditions, and whenever we see a leaf add num to sum
// Finally return the sum.
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
        sum = 0;
        preorder(root, 0);
        return sum;
    }
    private void preorder(TreeNode root, int num){
        if(root == null)
            return;
        num = 10 * num + root.val;
        if(root.left == null && root.right == null){
            sum+= num;
            return;
        }
        
        preorder(root.left, num);
        preorder(root.right, num);
    }
}