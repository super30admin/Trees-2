// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.Arrays;

public class BinaryTreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        if (postorder.length == 1) {
            return root;
        }

        int index = -1;

        for (int i = 0; i < postorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }

        int[] postleft = Arrays.copyOfRange(postorder, 0, index);
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] postright = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        int[] inright = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);

        return root;
    }
}
