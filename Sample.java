//****SUM ROOT TO LEAF NUMBERS****
// Time Complexity :O(n)
// Space Complexity :o(h)
// Did this code successfully run on Leetcode :Y
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
    int currnum=0;
    public int sumNumbers(TreeNode root) {
        
        helper(root, currnum);
        return result;
        
    }
    
    private void helper(TreeNode root, int currentnum)
    {
        //BASE CASE
        if(root==null)
        {
            return;
        }
        
        //LOGIC
        helper(root.left, currentnum * 10 + root.val);
        if(root.left==null && root.right==null)
        {
            result += currentnum*10+root.val;
        }
        
        helper(root.right,currentnum*10+root.val);
    }
}
