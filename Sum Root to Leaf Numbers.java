//time n
//space constant

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

    int res = 0;

    public int sumNumbers(TreeNode root)
    {

        helper(root,0);

        return res;
    }

    private void helper(TreeNode root , int cursum)
    {
        if(root == null) return;

        cursum = cursum*10 + root.val;

        //leaf
        if(root.left == null && root.right == null) res+=cursum;

        helper(root.left,cursum);

        helper(root.right,cursum);
    }
}
