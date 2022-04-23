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
//TC : O(n) SC : O(height of tree)
class Solution {
    //Integer totalSum=0;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;

        return helper(root,0);
        //return totalSum;
    }

    private int helper(TreeNode root,int sumSoFar)
    {
        if(root==null) return 0;

        if(root.left == null && root.right==null)
        {
            return sumSoFar*10+root.val;

        }

        int c1 = helper(root.left,sumSoFar*10+root.val);
        System.out.println(root.val+" : "+sumSoFar);
        int c2 = helper(root.right,sumSoFar*10+root.val);

        return c1+c2;

    }
}