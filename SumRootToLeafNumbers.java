// Time Complexity : O(n)
// Space Complexity : O(1), O(n^2) if recursion stack is considered
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : A little tricky to understand edge case and initial value we're passing.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
       return helper(root, 0);
    }
    
    public int helper (TreeNode root, int value) {
        
        if (root == null) return 0;
        if (root.left == null && root.right == null) return value*10 + root.val;
        
        int leftSum = helper(root.left,value*10 + root.val);
        int rightSum = helper(root.right,value*10 + root.val);
        return leftSum + rightSum;
    }
}