// Time Complexity : O(n)
// Space Complexity : O(h), where h - height
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
class SumRootToLeaf {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int sum){
        if(root == null) return;
        
        sum = 10 * sum + root.val;
        
        helper(root.left, sum);
        
        if(root.left == null && root.right == null){
            result += sum;
        }
        
        helper(root.right, sum);
    }
}