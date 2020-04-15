/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Time Complexity: O(n)
// Space COmplexity with recursive stack: O(maxDepth + space required for arrays)
// Space COmplexity without recursive stack: O(space required for arrays)
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postorder.length - 1]);

        int index = -1;
        for(int i=0; i<inorder.length; i++) {
            if(inorder[i] == root.val) {
                index = i;
            }
        }

        int[] post_left = Arrays.copyOfRange(postorder, 0, index);
        int[] inorder_left = Arrays.copyOfRange(inorder, 0, index);

        int[] post_right = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        int[] inorder_right = Arrays.copyOfRange(inorder, index+1, inorder.length);

        root.left = buildTree(inorder_left, post_left);
        root.right = buildTree(inorder_right, post_right);

        return root;
    }
}