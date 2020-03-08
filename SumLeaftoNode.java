//o(n) time and o(height) space
//passed all leetcode cases
//used recursive approach
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
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    private int helper(TreeNode root,int val1){
        //base
        if(root == null) return 0;
        if(root.left == null && root.right == null) return val1*10 +root.val;
        //logic
        return helper(root.left,val1*10 +root.val)+helper(root.right,val1*10 +root.val);
    }
}