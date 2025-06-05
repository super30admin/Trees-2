// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    public int sumNumbers(TreeNode root) {
        return helper (root, 0);
        
    }
    private int helper( TreeNode node, int currentnumber){
        if(node == null){
            return 0;
        }
        int newnumber = currentnumber *10+ node.val;
        if (node.left== null && node.right ==null){
            return newnumber;
        }

        int sumleft= helper(node.left, newnumber);
        int sumright= helper(node.right, newnumber);
        return sumleft+sumright;
    }
}