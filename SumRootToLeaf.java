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
class SumRootToLeaf {
    int result;

    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum)
    {
        //base case
        if(root == null) return;

        //logic
        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null) //leaf node
        {
            result += currNum;
            return;
        }

        helper(root.left, currNum);

        helper(root.right, currNum);
    }
}
