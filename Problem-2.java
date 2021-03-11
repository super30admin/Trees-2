// Time Complexity :O(n)
// Space Complexity :O(H) - height of the tree
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
class Solution {
    private int output = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null) return output;
        calSum(root,0);
        return output;
        
    }
    
    private void calSum(TreeNode root, int currSum){
        if(root==null) return;
        currSum = currSum * 10 + root.val;
        if(root.left== null && root.right == null){
            output += currSum;
            return;
        }
        calSum(root.left, currSum);
        calSum(root.right, currSum);
    }
}