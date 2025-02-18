// Time Complexity : O(n)
// Space Complexity : O(1)
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

    int result;
    public int sumNumbers(TreeNode root) {

        this.result = 0;
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode root, int currSum) {

        //If we have left subtree but don't have right subtree or vice versa. We face this condition
        if(root == null)
            return;

        //we will add the curr node
        currSum = currSum * 10 + root.val;

        //If we reach the leaf node, then we need to add the sum to result
        if(root.left == null && root.right == null) {

                result += currSum;
                return;
        }

        //go to left subtree until we find leaf node
        helper(root.left, currSum);

        //go to right subtree until we find leaf node
        helper(root.right, currSum);
    }
}