// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
        // call the recursive function and return the calculated sum
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int num){
        // base
        // if lead node is reached
        if(root == null) return;
            
        // logic
        // calculate sum for left children nodes
        helper(root.left, num*10 + root.val);
        // root = st.pop()[0] sum = st.pop()[1];
        
        // update the sum when leaf node is reached
        if(root.left == null && root.right == null){
            sum += num * 10 + root.val;
        }
        
        // calculate sum for right children nodes
        helper(root.right, num *10 + root.val);
    }
}