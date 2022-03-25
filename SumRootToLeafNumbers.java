/**
 * Time complexity is O(n)
 * 
 * space complexity is O(1) - no additional space allocated - O(h) - stack size
 */

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int num) {
        if(root == null) {
            return 0;
        }
        int val = num * 10 + root.val;
        if(root.left == null && root.right == null) {
            return val;
        }
        
        return helper(root.left, val) + helper(root.right, val);
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}