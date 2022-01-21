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
    
    private void helper(TreeNode root, int num){
        
        if(root == null) return null;
        
        helper(root.left, num*10 + root.val);
        // root = st.pop[0] num = st.pop[1]
        // 5, 49
        if(root.left == null && root.right == null){
            sum + = num * 10 + root.val;
        }
        helper(root.right, num*10 + root.val);
        
    }
}


// Time Complexity : o(N)
// Space Complexity : O(h) hight of tree
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach