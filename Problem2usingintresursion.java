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
 //int based recursion
 //TC: O(n)
 //Sc: O(h)
 class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root, int currNum){
        //base
        if(root == null) return 0;
        currNum = currNum*10 + root.val;
        if(root.left == null && root.right == null)
        {
           return  currNum;
        }
        int left = helper(root.left, currNum);
        int right = helper(root.right, currNum);
        return left + right;
    }
}