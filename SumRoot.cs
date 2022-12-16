/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    int result;
    public int SumNumbers(TreeNode root) {
        result = 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int currSum)
    {
        if(root == null) return;
        currSum = currSum * 10 + root.val;
        helper(root.left, currSum);
        if(root.left == null && root.right == null)
        {
            result += currSum;
        }
        helper(root.right, currSum);

    }
}
