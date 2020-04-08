// Time Complexity : O(n+m)
// Space Complexity :O(depth of tree)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int globalSum=0;
    public int sumNumbers(TreeNode root) {
    
        helper(root,0);
        return globalSum;
    }
    private void helper(TreeNode root, int currentSum)
    {
        //base case
        if(root==null)
            return;
        
        //Processing
        if(root.left==null && root.right==null)
        {
            globalSum += currentSum+root.val;
            return;
            
        }
        int pass_on = (currentSum+root.val)*10;
        helper(root.left,pass_on);
        helper(root.right,pass_on);
    }
    
    
}