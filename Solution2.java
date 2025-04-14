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

    int sum;
    public int sumNumbers(TreeNode root) {
        this.sum = 0;

        helper(root, 0);
        return sum;


    }

    private void helper(TreeNode root, int currSum)
    {
        if(root == null) return;

        if(root.left == null && root.right == null)
        {
            sum = sum + currSum*10 + root.val;
        }
        currSum = currSum*10 + root.val;
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}