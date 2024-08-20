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
 // Time complexity = O(n)
 // Space complexity = O(1)
 // Recursion with int result.
class SumRootToLeafIntRecursive {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);// start from the root val.
    }
    
    private int helper(TreeNode root, int sum ) {
        if(root==null) {
            return 0 ;
        }
        sum = sum*10 + root.val; // 1    
        if(root.left == null && root.right == null) {
            return sum;
        }
        return helper(root.left, sum) + helper(root.right, sum);
    }
}