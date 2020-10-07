/**
 *  Time Complexity - O(h)
 *  Space Complexity - O(n)
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
    int total_sum =0;
    public int sumNumbers(TreeNode root) {
        helper(root,total_sum);
        return total_sum;
        
    }
    
    public void helper (TreeNode root, int curr_sum)
    {
        if(root == null) return;
        if(root.left == null && root.right == null)
        {
            this.total_sum = total_sum + curr_sum*10 + root.val;
            return;
        }
        curr_sum = curr_sum*10 + root.val;
        helper(root.left, curr_sum);
        helper(root.right, curr_sum);
    }
}