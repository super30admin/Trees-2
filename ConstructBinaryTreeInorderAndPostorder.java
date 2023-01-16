// Time Complexity : O(N)
// Space Complexity : O(N) + O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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

public class ConstructBinaryTreeInorderAndPostorder {
    HashMap<Integer, Integer> inOrderMap;
    private int btIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inOrderMap = new HashMap<>();
        btIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTreeHelper(postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[btIndex];

        btIndex--;
        int rootIdx = inOrderMap.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.right = buildTreeHelper(postorder, rootIdx + 1, end);
        root.left = buildTreeHelper(postorder, start, rootIdx - 1);

        return root;
    }
}