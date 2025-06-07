// Time complexity - O(n^2)
// Space complexity - O(n)
// Did you face any issues - No
// Solved on leetcode - yes
//This code reconstructs a binary tree from its inorder and postorder traversal arrays using a recursive helper function. It identifies the root from the end of the postorder array, then searches for the root's index in the inorder array to divide the elements into left and right subtrees. The function first builds the right subtree (since postorder ends with the root after the right subtree) and then the left, adjusting the indices accordingly for each recursive call until the entire tree is built.
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length - 1, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        if (inStart > inEnd || postEnd < 0) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        // Find root index in inorder
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        int rightTreeSize = inEnd - index;

        // Build right first (because postorder ends with root after right subtree)
        root.right = helper(inorder, postorder, index + 1, inEnd, postEnd - 1);
        root.left = helper(inorder, postorder, inStart, index - 1, postEnd - rightTreeSize - 1);

        return root;
    }
}
