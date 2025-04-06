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
 * TC: O(n)
 * SC: O(n)
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        if (postorder.length == 1) return root;

        int index = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        if (index == -1) return null;

        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postleft = Arrays.copyOfRange(postorder, 0, index);
        int[] postright = Arrays.copyOfRange(postorder, index, postorder.length - 1);

        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);
        
        return root;
    }
}