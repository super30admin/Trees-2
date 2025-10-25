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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        if(postorder.Length == 0)
        {
            return null;
        }
        int rootValue=postorder[postorder.Length-1];
        int rootIndex = -1;
        for(var i=0;i<inorder.Length;i++)
        {
            if(rootValue == inorder[i])
            {
                rootIndex = i;
                break;
            }
        }
        int[] inLeft = new int[rootIndex];
        Array.Copy(inorder, 0, inLeft, 0, rootIndex);
        int[] inRight = new int[inorder.Length - rootIndex - 1];
        Array.Copy(inorder, rootIndex + 1, inRight, 0, inRight.Length);
        int[] postLeft = new int[inLeft.Length];
        Array.Copy(postorder, 0, postLeft, 0, inLeft.Length);
        int[] postRight =  new int[inRight.Length];
        Array.Copy(postorder, inLeft.Length, postRight, 0, inRight.Length);
        TreeNode root = new TreeNode(rootValue);
        root.left = BuildTree(inLeft,postLeft);
        root.right = BuildTree(inRight,postRight);

        return root;
        
    }
}