// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ConstructBinaryTreeFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInorder = inStart;
        while (inorder[rootIndexInorder] != rootVal) {
            rootIndexInorder++;
        }

        int leftSubtreeSize = rootIndexInorder - inStart;

        root.left = buildTreeHelper(inorder, inStart, rootIndexInorder - 1, postorder, postStart, postStart + leftSubtreeSize - 1);
        root.right = buildTreeHelper(inorder, rootIndexInorder + 1, inEnd, postorder, postStart + leftSubtreeSize, postEnd - 1);

        return root;
    }
}
