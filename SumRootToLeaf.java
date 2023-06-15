// Time Complexity : O(h) -- h is the height of the tree -- not sure
// Space Complexity : O(h) -- h is the height of the tree -- not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to refer the class discussion for the exact approach
/* 
 * Took the total sum at the end of each leaf node as a global variable
 * and took the each paths number formed as currNum as the local variable as 
 * each path must have a unique number formed.
 */


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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        helper(root,0);
        return sum;
    }

    private void helper(TreeNode root,int currNum){
        // base condition
        if(root == null){
            return;
        }

        //logic
        currNum = currNum*10 + root.val;
        // check if the current root is the leaf node
        if(root.left==null && root.right==null){
            sum = sum + currNum;
        }
        helper(root.left,currNum);
        // System.out.println(currNum);
        helper(root.right,currNum);
        // System.out.println(currNum);

    }
}