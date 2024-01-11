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
 //void based recursion
 //TC: O(n)
 //Sc: O(h)
 class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
    private void helper(TreeNode root, int currNum){
        //base
        if(root == null) return;
        currNum = currNum*10 + root.val;
        if(root.left == null && root.right == null)
        {
            result += currNum;
        }
        helper(root.left, currNum);
        helper(root.right, currNum);
    }
}