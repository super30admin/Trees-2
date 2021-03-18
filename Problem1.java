// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {

        HashMap<Integer, Integer> hp = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            hp.put(inorder[i], i);
        }

        return buildT(inorder, 0, postorder, 0, inorder.length, hp);

    }

    private TreeNode buildT(int[] inorder, int i, int[] postorder, int p, int size, HashMap<Integer, Integer> hp) {

        if (size == 0) {
            return null;
        }

        if (size == 1) {
            return new TreeNode(inorder[i]);
        }

        int rootVal = postorder[p + size - 1];
        int rootIndex = hp.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        int leftSize = rootIndex - 1 - i + 1;
        int rightSize = size - (leftSize + 1);

        root.left = buildT(inorder, i, postorder, p, leftSize, hp);
        root.right = buildT(inorder, rootIndex + 1, postorder, p + leftSize, rightSize, hp);

        return root;

    }
}