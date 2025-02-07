// Time complexity: O(N)
// Space complexity: O(N)
// Leetcode: Yes

import java.util.HashMap;

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
    int idx;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        idx = postorder.length - 1;

        return createTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode createTree(int[] postorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx--;

        int rootIdx = map.get(rootVal);

        root.right = createTree(postorder, rootIdx + 1, end);
        root.left = createTree(postorder, start, rootIdx - 1);

        return root;
    }
}
