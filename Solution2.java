// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
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
        int sum;
        public int sumNumbers(TreeNode root){
            if(root == null){
                return 0;
            }
            helper(root, 0);
            return sum;
        }

        private void helper(TreeNode root, int currSum){
            //base
            if(root == null){
                return;
            }
            //logic
            currSum = currSum * 10 + root.val;
            helper(root.left, currSum);
            helper(root.right, currSum);
            if(root.left == null && root.right == null){
                sum += currSum;
            }

        }

    }
