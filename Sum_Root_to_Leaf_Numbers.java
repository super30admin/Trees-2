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
// TC : O(n)
// SC : O(h) - height of tree
class Solution {
    public int sumNumbers(TreeNode root) {
        
        if(root == null) return 0;
        
        return helper(root, 0);
        
    }
    
    private int helper(TreeNode root, int rsum) {
        if(root == null) return 0;
        
        if(root.left == null && root.right == null)
            return (rsum*10) + root.val;
        
        int case1 = helper(root.left, (rsum * 10)+root.val);
        int case2 = helper(root.right, (rsum * 10)+root.val);
        
        return case1 + case2;
    }
}
