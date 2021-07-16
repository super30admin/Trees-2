// Time Complexity : O(n)
// Space Complexity : O(height)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    //creating global variable to store final sum
    int result;
    public int sumNumbers(TreeNode root) {
       if(root == null)
           return 0;
        
        //recursive approach, so call helper function and pass root & current sum
        helper(root, 0);
        //finally, return total sum
        return result;
    }
    
    private void helper(TreeNode root, int curSum){
        //base
        if(root == null)
            return;
        //left
        curSum = curSum * 10 + root.val;
        helper(root.left, curSum);
        //root
        //check if leaf not or not
        if(root.left == null && root.right == null)
            result += curSum;
        //right
        helper(root.right, curSum);
    }
}
