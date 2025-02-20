// time complexity - O(n) n= nodes in tree
// space complexity - O(h) h = height of tree
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
    int result = 0;
    public int SumNumbers(TreeNode root)
    {
        helper(root, 0);
        return result;
    }
    public void helper(TreeNode root, int curr)
    {
        // base
        if (root == null)
        {
            return;
        }
        // left
        curr = curr * 10 + root.val;
        helper(root.left, curr);

        if (root.left == null && root.right == null)
        {
            result += curr;
        }
        // right
        helper(root.right, curr);
    }
}