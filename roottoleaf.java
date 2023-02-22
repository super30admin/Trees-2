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
         helper(root,0);
         return result;
    }
    private int helper(TreeNode root, int curSum){
        if(root==null) return 0;
        if(root.right==null && root.left==null) result+= curSum*10+root.val;
        int left= helper(root.left,curSum*10+root.val);
        int right=helper(root.right,curSum*10+root.val);
        return left+right;
    }
}