//TC: O(n)
//SC: O(n)
//approach: get root from postorder, and search for it in inorderMap,
//// left of root in inorder is left subtree, right is right subtree and so on

import java.util.HashMap;

public class ConstructBinaryTreeFromInorderAndPostOrderTraversal {
    private HashMap<Integer, Integer> inorderMap = new HashMap<>();
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        postIndex = postorder.length - 1;
        return construct(postorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = inorderMap.get(rootVal);

        root.right = construct(postorder, inIndex + 1, inEnd);
        root.left = construct(postorder, inStart, inIndex - 1);

        return root;
    }
}
