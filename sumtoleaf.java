//TC:O(n)
//SC:O(max height of the tree)
//successfully ran on leetcode
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
    private int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return sum;

        helper(root,0);
        return sum;

    }
    private void helper(TreeNode root,int curr)
    {
        if(root==null)
            return;
        curr=curr*10+root.val;

        if(root.left==null && root.right==null)
        {
            sum+=curr;
            return;
        }
        helper(root.left,curr);
        helper(root.right,curr);
    }

}
