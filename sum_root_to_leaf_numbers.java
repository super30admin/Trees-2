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

// Time Complexity: O(n)
// Space Complexity: O(h)
// Did this code run on Leetcode successfully? : Yes
class Solution {
    private int result = 0;
    
    private void sumNumbersHelper(TreeNode root, int currSum) {
        // base case
        if (root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            result += (currSum*10 + root.val);
        }

        // logic
        sumNumbersHelper(root.left, currSum*10 + root.val);
        sumNumbersHelper(root.right, currSum*10 + root.val);
    }

    public int sumNumbers(TreeNode root) {
        sumNumbersHelper(root, 0);
        return result;
    }
}