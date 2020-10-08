// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach: Used recurrssion  method to call left and right node of root node and calculating the sum

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
    int total_sum = 0;
    public int sumNumbers(TreeNode root) {
        
        helper(root, total_sum);
        return total_sum;
        
    }
    
    private void helper(TreeNode root, int curr_sum){
        //Base case
        if(root == null) return;
        
        if(root.right == null && root.left == null){
            total_sum = total_sum + curr_sum*10 + root.val;
            return;
        }
        
        curr_sum = curr_sum*10 + root.val;
        helper(root.left, curr_sum);
        helper(root.right, curr_sum);
    }
}
