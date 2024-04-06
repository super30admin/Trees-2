
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

// Tc: O(n) Sc: O(n)
class Solution {
    int postIndex;
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }

        return buildTreeRecursive(0, inorder.length - 1, postorder);
    }

    private TreeNode buildTreeRecursive(int inStart, int inEnd, int[] postorder) {
        if (inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);

        int inIndex = indexMap.get(root.val);

        root.right = buildTreeRecursive(inIndex + 1, inEnd, postorder);
        root.left = buildTreeRecursive(inStart, inIndex - 1, postorder);

        return root;
    }
}