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
    int index;
    Dictionary<int, int> lookup;
    public TreeNode BuildTree(int[] inorder, int[] postorder)
    {
        if (inorder == null || inorder.Length == 0 || postorder == null || postorder.Length == 0 || inorder.Length != postorder.Length)
        {
            return null;
        }

        lookup = new Dictionary<int, int>();
        for (int i = 0; i < inorder.Length; i++)
        {
            lookup.Add(inorder[i], i);
        }
        index = postorder.Length - 1;
        return CreateTree(postorder, 0, index);
    }

    public TreeNode CreateTree(int[] postorder, int start, int end)
    {
        if (start > end)
        {
            return null;
        }
        TreeNode root = new TreeNode(postorder[index]);
        int rootIndex = lookup[postorder[index]];
        index--;

        root.right = CreateTree(postorder, rootIndex + 1, end);
        root.left = CreateTree(postorder, start, rootIndex - 1);

        return root;
    }
}