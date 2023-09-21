import java.util.Arrays;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    // TC : O(n^2). //SC : O(n^2)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = -1;

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, inorder.length);
        int[] preLeft = Arrays.copyOfRange(preorder, 1, 1 + inLeft.length);
        int[] preRight = Arrays.copyOfRange(preorder, 1 + inLeft.length, preorder.length);

        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }

    int result = 0;

    // TC : O(n) //SC : O(h)
    public int sumNumbers(TreeNode root) {
        Helper(root, 0, 0);
        return result;
    }

    private void Helper(TreeNode root, int prev, int curr) {
        if (root == null)
            return;
        curr = prev * 10;
        prev = root.val + curr;
        Helper(root.left, prev, curr);
        Helper(root.right, prev, curr);
        if (root.left == null && root.right == null) {
            result = result + prev;
        }
    }

}