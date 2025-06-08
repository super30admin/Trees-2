import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 */
public class TreeFromPostOrderInOrder {
    /**
     * Logic is exactly same as in Tree-1 pre and inorder problem. Difference here is we have postorder instead of the preorder
     * so processing postorder array behind and processing right subtree before left subtree will give us the needed solution
     *
     * TC: O(n) Auxiliary SC: O(n) due to hashmap
     * Recursive stack space: O(h) h -> height of tree, worst case O(n), complete BST O(log n)
     */
    int postorderIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        this.postorderIdx = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(postorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] postorder, Map<Integer, Integer> inorderMap, int start, int end) {
        //base
        if (start > end) {
            return null;
        }

        //logic
        TreeNode root = new TreeNode(postorder[postorderIdx--]);
        int inorderIdx = inorderMap.get(root.val);
        root.right = buildTree(postorder, inorderMap, inorderIdx + 1, end);
        root.left = buildTree(postorder, inorderMap, start, inorderIdx - 1);

        return root;
    }
}
