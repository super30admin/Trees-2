// Time Complexity :O(n)
// Space Complexity :O(h)
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
    int result=0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return 0;
        }
        helper(root,0);
        return result;
    }
    
    public void helper(TreeNode root,int curSum){
        if(root==null){
            return;
        }
        if(root.left==null && root.right==null){
           // System.out.println(10*curSum+root.val);
            result=result+10*curSum+root.val;
            return;
        }
        helper(root.left,curSum*10+root.val);
        helper(root.right,curSum*10+root.val);
        
    }
}