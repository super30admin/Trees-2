/*
Time Complexity: O(N) where N is the number of nodes in the tree.
Space Complexity: O(h) where h is the height of the tree.
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

*/

public class BinaryTreeInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
            int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element in postorder is the root
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of the root in inorder array
        int rootIndex = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Calculate the size of the left subtree
        int leftSize = rootIndex - inStart;

        // Recursively build the left and right subtrees
        root.left = buildTree(inorder, inStart, rootIndex - 1,
                postorder, postStart, postStart + leftSize - 1);
        root.right = buildTree(inorder, rootIndex + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeInorderPostorder solution = new BinaryTreeInorderPostorder();
        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        solution.buildTree(inorder, postorder);
    }

}
