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
// Time Complexity : O(n) 
// Space Complexity :O(n) n is the stack size 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :No
//  get the sum at every node and keep it in the stack
// Your code here along with comments explaining your approach
class Solution {
    int total;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        helper(root,0);
        return total;
    }
    
    void helper(TreeNode root, int sum){
        if(root==null) return ;
        sum=sum*10+root.val;
        helper(root.left,sum);
        if(root.left==null && root.right==null){
            total+=sum;
        }
        helper(root.right,sum);
    }
}