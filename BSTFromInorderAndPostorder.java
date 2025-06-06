// Time complexity O(n)
// Space complexity O(h + n)
// Runs on LeetCode: YES
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
class BSTFromInorderAndPostorder {
    int idx;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        idx = postorder.length - 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(postorder, map, 0, postorder.length - 1);
    }

    private TreeNode helper(int[] postorder, Map<Integer, Integer> inorderLookup, int start, int end) {

        if (end < start) {
            return null;
        }

        int rootValue = postorder[idx];
        TreeNode root = new TreeNode(rootValue);
        idx--;
        int rootIndex = inorderLookup.get(rootValue);

        int startLeft = start;
        int endLeft = rootIndex - 1;
        int startRight = rootIndex + 1;
        int endRight = end;

        root.right = helper(postorder, inorderLookup, startRight, endRight);
        root.left = helper(postorder, inorderLookup, startLeft, endLeft);

        return root;
    }
}
