// Time Complexity : O(n)
// Space Complexity :O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 


// Your code here along with comments explaining your approach
//we take sum as a global variable. we need to calculate sum of all paths so we pass root to the recursion
//along with current value. current value can be considered as curr*10 + root.val. clculate this at
//each node it its not null.. and resturn if its leaf node i. e. left and right trees are null
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
    
    int sum=0;
    
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return sum;
        }
        
        helper(root, 0);
        return sum;
        
    }
    
    private void helper(TreeNode root, int curr){
            if(root==null){
                return;
            }
            curr= curr*10+root.val;
            
            if(root.left==null && root.right==null){
                sum= sum+curr;
                return;
            }
            
            helper(root.left, curr);
            helper(root.right, curr);
        }
        
}