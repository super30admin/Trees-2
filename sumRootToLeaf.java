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
        helper(root, 0);
        return sum;
    }
    
    public void helper(TreeNode root, int num){
        //base
        if(root == null)
            return;
        
        //logic
        if(root.left == null && root.right == null)
            sum += num * 10 + root.val;
        
        
        helper(root.left, num * 10 + root.val);
        helper(root.right, num * 10 + root.val);
    }
}
