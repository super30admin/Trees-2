/* Time Complexity: O(n)
 * Space Complexity: O(h), h is the height of the tree
 * Did this code successfully run on Leetcode : yes
 * Any problem you faced while coding this : No
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
        return helper(root,0);
    } 
    private int helper(TreeNode root, int currNum){
        //base
        if(root == null) return 0;
        //logic
        if(root.left == null && root.right == null){
            return currNum * 10 + root.val;
        }
        return 
            helper(root.left, currNum * 10 + root.val) + helper(root.right, currNum * 10 + root.val);
    }
}