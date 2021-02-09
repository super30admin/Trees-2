// Time Complexity :O(n)
// Space Complexity :O(depth)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


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
    private int output;
    public int sumNumbers(TreeNode root) {
        output=0;
        int curr=0;
        cal(root,curr);
        return output;
    }
    private void cal(TreeNode root, int curr)
    {
        if(root==null)
            return;
        
        curr=curr*10+root.val;
        if(root.left==null &&  root.right==null){
            output+=curr;
            return;
        }
        
        cal(root.left,curr);

        cal(root.right,curr);
  
    }
}