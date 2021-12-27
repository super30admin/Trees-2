// Time Complexity : O(n)
// Space Complexity : O(H) (recursive stack ; H is the height of the tree)
// Did this code successfully run on Leetcode 129 :yes
// Any problem you faced while coding this :No


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

    public int sumNumbers(TreeNode root) {

     if(root==null)
         return 0;

       return helper(root,0);
        }
    private int helper(TreeNode root,int cursum){
        if(root==null)
            return 0;

         if(root.left==null && root.right==null){
            cursum=cursum*10+root.val;
             return cursum;
         }


        return helper(root.left,cursum*10+root.val)+helper(root.right,cursum*10+root.val);



    }


}