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
public class Solution
{
    int totalSum;
    public int SumNumbers(TreeNode root)
    {
        GetSum(root, 0);
        return totalSum;
    }

    public void GetSum(TreeNode root, int prevSum)
    {
        if (root == null)
        {
            return;
        }
        prevSum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null)
        {
            totalSum += prevSum;
        }
        GetSum(root.left, prevSum);
        GetSum(root.right, prevSum);
    }
}