// Time Complexity : O(n) where n is the total numbers of nodes in the tree
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    int result;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return result;
    }
    
    public void helper(TreeNode root, int currSum){
        // base
        if(root == null){
            return;
        }
        
        //logic
        if(root.left == null && root.right == null){
            result += currSum*10 + root.val;
        }
        helper(root.left, currSum*10 + root.val);
        helper(root.right, currSum*10 + root.val);
        
        return;
    }
}