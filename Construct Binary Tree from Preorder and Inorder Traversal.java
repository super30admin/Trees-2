#time complexity=O(n)
#space complexity=O(h)
class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder.length == 0) return null;
        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        int[] inorderleft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inorderright = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);

        int[] preorderleft = Arrays.copyOfRange(preorder, 1, rootIdx + 1);
        int[] preorderright = Arrays.copyOfRange(preorder, rootIdx + 1, preorder.length);

        root.left = buildTree(preorderleft, inorderleft);
        root.right = buildTree(preorderright, inorderright);
        return root;
    }
}
