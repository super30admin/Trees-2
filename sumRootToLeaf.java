// Time Complexity: O(n)
// Space Complexity: O(Edge)
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
    int result = 0;
    int currSum = 0;
    
    public int sumNumbers(TreeNode root) {
        helper(root);
        return result;
    }
    
    public void helper(TreeNode root){
        if(root == null) return;
        
        currSum = currSum * 10 + root.val;
        helper(root.left);
        if(root.left == null && root.right == null){
            result += currSum;
        }
        helper(root.right);
        currSum = currSum / 10;
    }
}