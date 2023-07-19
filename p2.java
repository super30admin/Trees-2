// Time Complexity : O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


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
    //Global variable sum which is the result
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        //Passing root node and local variable sum
        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int rs){

//Base condiiton
// When node is null, return
        if(root == null) return;

        //Getting the local variable value of sum
        rs = rs*10 + root.val;

        //If it is a leaf node, add it to the global variable sum
        if(root.left == null && root.right == null){
            sum = sum + rs;
            return;
        }

        
//Left node recursion
        helper(root.left, rs);
//Right node recurison
        helper(root.right, rs);
    }
}