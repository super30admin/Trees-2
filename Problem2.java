// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no
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
    //result is global so we can acess it in any function
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        //Initialize current sum to zero
        int curSum = 0;
        //call helper
        helper(root, curSum);
        return result;

    }

    private void helper(TreeNode root, int curSum){
        
        if(root == null) return;
        curSum = curSum * 10 + root.val;
        //go all the way left until root equal null
        helper(root.left, curSum);
        //when you hit leaf node verify if it is a leaf node then add curSum into result
        if(root.left == null && root.right == null){
                result += curSum;
        }
        //pop happens and now you check root's right
        helper(root.right, curSum);
    }
}