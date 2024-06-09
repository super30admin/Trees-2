import java.util.HashMap;
import java.util.Map;

/***
 * TC - O(n), SC - O(h)
 */


class ConstructBT {
    Map<Integer, Integer> hm = new HashMap<>();
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;

        idx = postorder.length-1;

        for(int i =0; i<inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        return recurse(postorder, 0, inorder.length-1);
    }

    private TreeNode recurse(int[] postorder, int start, int end) {
        if(start > end)
            return null;

        int rootVal = postorder[idx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = hm.get(rootVal);

        root.right = recurse(postorder, rootIdx+1, end);
        root.left = recurse(postorder, start, rootIdx-1);

        return root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}