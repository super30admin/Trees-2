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
    //TC = O(n^2)
    //SC = O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        //TC = O(n)
        for(int i = 0; i < inorder.length; i++)
        {
            if(inorder[i] == rootVal) rootIdx = i;
        }

        //TC = O(n)
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, inLeft.length + 1);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
