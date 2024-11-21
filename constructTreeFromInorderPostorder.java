// Time Complexity : O(n^2) where n is the number of nodes in the tree
// Space Complexity : O(n) where n is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class constructTreeFromInorderPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) return null;
        int idx = -1;
        int r = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(r);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == r) {
                idx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx + 1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, idx);
        int[] postRight = Arrays.copyOfRange(postorder, idx, postorder.length - 1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        return root;
    }
}