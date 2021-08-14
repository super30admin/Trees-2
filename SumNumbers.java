/* Time Complexity :  O(n) where n is number of nodes
   Space Complexity :  O(h) where h is height of the recursion stack
   Did this code successfully run on Leetcode : Yes
   Any problem you faced while coding this : No
*/
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
        return helper(root, 0);
    }
    private int helper(TreeNode root, int cursum){  
        if(root==null)
        {
            return 0;
        }
        if(root.left==null && root.right==null)
        {
            return (cursum*10)+root.val;  
        }
        return helper(root.left,(cursum*10)+root.val)+helper(root.right,(cursum*10)+root.val);
    }
}