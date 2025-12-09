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

// Approach: Recursion using map
// Time: O(N)
// Space: N for map + N for recursive stack ~= O(N)
class Solution {

    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inorderMap.put(inorder[i], i);
        }
        // root will start at last index of postorder
        postIndex = postorder.length - 1;
        return helper(postorder, inorderMap, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, Map<Integer, Integer> inorderMap, int start, int end) {

        // base
        if (start > end) {
            return null;
        }

        // logic
        // find root in inorder
        int rootVal = postorder[postIndex];
        postIndex --;
        int rootIndex = inorderMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);

        // logic
        // Populate right first and then left
        root.right = helper(postorder, inorderMap, rootIndex + 1, end);
        root.left = helper(postorder, inorderMap, start, rootIndex - 1);

        return root;
    }
}