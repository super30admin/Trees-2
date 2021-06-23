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
    int currSum = 0;
    int result = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return result;
    }

    private void helper(TreeNode root){

        if (root == null) return ;
        currSum = currSum * 10 + root.val;
        helper(root.left);
        if(root.left == null && root.right == null ){
            result += currSum;
        }
        helper(root.right);
        currSum /= 10;


    }
}