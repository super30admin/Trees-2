import java.util.HashMap;

class Solution {
    int idx;
    HashMap<Integer, Integer> m;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        m = new HashMap<>();
        idx = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            m.put(inorder[i], i);
        }
        return recur(postorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode recur(int[] postorder, int[] inorder, int start, int end) {
        if (start > end)
            return null;

        int rootVal = postorder[idx--];
        int rootIdx = m.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        root.right = recur(postorder, inorder, rootIdx + 1, end);
        root.left = recur(postorder, inorder, start, rootIdx - 1);

        return root;
    }
}