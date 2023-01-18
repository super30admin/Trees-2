//tc : O(n*n)
//sc : O(n*n)
//run successfull
//no problems

//performed recursion on the main method
//by picking by the root and passing the rest left and right
//inorder and postorder arrays

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        int len = postorder.length;
        int ind = postorder[len - 1];
        TreeNode root = new TreeNode(ind);
        for (int i = 0; i < len; i++) {
            if (inorder[i] == ind) {
                ind = i;
                break;
            }
        }

        int[] inleft = Arrays.copyOfRange(inorder, 0, ind);
        int[] inright = Arrays.copyOfRange(inorder, ind + 1, len);
        int[] postleft = Arrays.copyOfRange(postorder, 0, ind);
        int[] postright = Arrays.copyOfRange(postorder, ind, len - 1);

        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);
        return root;

    }
}