// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :nopes
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
    int result;

    public int sumNumbers(TreeNode root) {
        if(root==null)
            return result;

        helper(root,0);

        return result;
    }

    public void helper(TreeNode root,int currSum)
    {
        if(root==null)
            return;

        if(root.left==null&&root.right==null)
            result=result+currSum*10+root.val;

        helper(root.left,currSum*10+root.val);

        helper(root.right,currSum*10+root.val);

    }
}