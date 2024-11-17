/*
Time complexity : O(N).

Space complexity : O(N).
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

    private int helper(TreeNode root, int currNum)
    {
        //base case
        if(root == null) return 0;

        //logic
        currNum = currNum * 10 + root.val;
        int numAtNode = 0;

        if(root.left == null && root.right == null) //leaf node
        {
            numAtNode = currNum;
        }

        int left = helper(root.left, currNum);

        int right = helper(root.right, currNum);

        return left+right+numAtNode;
    }
}
