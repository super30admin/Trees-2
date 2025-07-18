class Solution {
    private int pindex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        pindex = postorder.length - 1;
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1, inmap);
    }

    private TreeNode helper(int[] postorder, int s, int e, Map<Integer, Integer> inmap) {
        if (s > e) return null;

        TreeNode root = new TreeNode(postorder[pindex--]);
        int index = inmap.get(root.val);

        // Build right subtree first
        root.right = helper(postorder, index + 1, e, inmap);
        root.left = helper(postorder, s, index - 1, inmap);

        return root;
    }
}
