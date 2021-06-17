class ConstructBSTPostInOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        TreeNode root = new TreeNode(preorder[0]);

        for (int i=1; i<preorder.length; i++) {

            root.left = preorder[i * 2 + 1];
            root.right = preorder[i * 2];

        }

        private void helper(inorder, postorder) {

        }

    }
}