import java.util.*;

public class ConstructBinary {

    int rootIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            h.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length - 1, h);
    }

    public TreeNode helper(int[] preorder, int start, int end, HashMap<Integer, Integer> map) {

        if (rootIdx == preorder.length || start > end) {
            return null;
        }
        int inorderIdx = map.get(preorder[rootIdx]);
        TreeNode root = new TreeNode(preorder[rootIdx]);
        rootIdx++;

        root.left = helper(preorder, start, inorderIdx - 1, map);
        root.right = helper(preorder, inorderIdx + 1, end, map);

        return root;
    }

    public class TreeNode {
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
}