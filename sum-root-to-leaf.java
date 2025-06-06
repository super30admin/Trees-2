// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


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
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }

    public void helper(TreeNode root, int currSum){
        if(root == null){
            return;
        }
        //logic
        currSum = currSum * 10 + root.val;
        //iterate through the tree
        helper(root.left, currSum);
        helper(root.right, currSum);
        // add the currSum to result if root is leaf node
        if(root.left == null && root.right == null){
            result += currSum;
        }
    }
}
