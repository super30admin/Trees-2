// Time Complexity : O(n)
// Space Complexity : O(H) - height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
Have a helper method to calculate the overall sum. We recursively call root's left and right by making sure
that both are not null. If we hit leaf nodes, it means we need to store the result for that branch. To form
current number, we multiply the digit with 10 and add root at each recursion. To end the recursion,
we use a base case to check if root is null.
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
    private int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        calculateSum(root, 0);
        return result;
    }

    private void calculateSum(TreeNode root, int currNum) {
        if(root == null)
            return;

        currNum = (currNum * 10) + root.val;

        if(root.left == null && root.right == null)
            result += currNum;
        calculateSum(root.left, currNum);
        calculateSum(root.right, currNum);
    }
}