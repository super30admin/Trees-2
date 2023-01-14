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

 // Time Complexity = O(N)
 // Space Complexity = O(1)

class Solution {
    private int result;
    public int sumNumbers(TreeNode root) {
        
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int currNum){
        // base condition
        if(root == null) return;
        
        currNum = currNum*10 + root.val;        
        if(root.left == null && root.right == null){
            result += currNum;
        }
        
        //left recursion
        helper(root.left, currNum);
        // stack pop will happen here
        
        //right recursion
        helper(root.right, currNum);
        // stack pop will happen here
        
    }
}

