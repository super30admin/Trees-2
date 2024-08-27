/*
    L.C - 106. Construct Binary Tree from Inorder and Postorder Traversal

    Time Complexity - O(N)
    Space Complexity - O(N)
*/

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
class ConstructBInaryTreeWithInAndPostOrder {
    private int postIdx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }

        postIdx = postorder.length - 1;
        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildSubTree(inorderMap, 0, inorder.length - 1, postorder);
    }

    private TreeNode buildSubTree(Map<Integer, Integer> inorderMap, int start, int end, int[] postorder) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = inorderMap.get(rootVal);

        root.right = buildSubTree(inorderMap, rootIdx + 1, end, postorder);
        root.left = buildSubTree(inorderMap, start, rootIdx - 1, postorder);

        return root;
    }
}

