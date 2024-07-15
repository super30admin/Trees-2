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
class BinaryTreeFromInorderToPostorder {

    int index;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        map = new HashMap();
        index = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int start, int end) {
        // base
        if (start > end)
            return null;

        // logic
        int rootVal = postorder[index];
        index--;
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = map.get(rootVal);

        root.right = helper(postorder, rootIndex + 1, end);

        root.left = helper(postorder, start, rootIndex - 1);

        return root;

    }

}