// Time Complexity: O(n)
// Space Complexity: O(n)

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
class Solution {
    int idx; // we use idx global variable to place our next root element from postorder
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length == 0 || inorder.length == 0) return null;

        Map<Integer, Integer> idxMap = new HashMap<>();

        for (int i=0 ;i<inorder.length; i++) {
            idxMap.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return buildTreeHelper(postorder, idxMap, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] postorder, Map<Integer, Integer> idxMap, int start, int end) {
        if (start > end) return null;

        int index = idx;

        int rootIdx = idxMap.get(postorder[idx]);

        TreeNode root = new TreeNode(postorder[idx]);

        idx--;

        root.right = buildTreeHelper(postorder, idxMap, rootIdx + 1, end);

        root.left = buildTreeHelper(postorder, idxMap, start, rootIdx - 1);

        return root;
    }
}
