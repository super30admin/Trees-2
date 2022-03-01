// Time Complexity : O(n)
// Space Complexity : O(tree height)
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
    
    public int sumNumbers(TreeNode root) {
        
        return sumNumbers(root, 0);
    }
    
    private int sumNumbers(TreeNode node, int num) {
        
        //num contains the value from lower level or leaf

        if(node == null) {
            return 0 ;
        }
        // at every node calyculate sum
        int sum = num *10 + node.val;
        
        //when at leaf, return the sum
        if(node.left == null && node.right == null) {
            return sum;
        }

        //calculate sums in left and right subTrees
        return sumNumbers(node.left, sum) + sumNumbers(node.right, sum);
    }
}