public class ConstructBinaryTreeFromInorderAndPostorder {
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
    Map<Integer, Integer> inorderMap = new HashMap<>();
    // TC: O(N) where N is length of array
    // SC: O(N + H) where N is length of array and H is max height of tree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        int rootVal = postorder[postEnd];
        int rootIndex = inorderMap.get(rootVal);
        int leftTreeLen = rootIndex - inStart;

        TreeNode root = new TreeNode(rootVal);
        root.left = helper(inorder, inStart, rootIndex - 1, postorder, postStart, postStart + leftTreeLen - 1);
        root.right = helper(inorder, rootIndex + 1, inEnd, postorder, postStart + leftTreeLen, postEnd - 1);
        return root;
    }
}
