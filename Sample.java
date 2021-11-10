// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
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
    int postorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeNode(postorder, 0, inorder.length-1);
    }
    private TreeNode buildTreeNode(int[] postorder, int start, int end) {

        if (start > end) return null;

        int inorderValue = postorder[postorderIndex--];
        int i = inorderMap.get(inorderValue);

        TreeNode node = new TreeNode(inorderValue);
        node.right = buildTreeNode(postorder, i+1, end);
        node.left = buildTreeNode(postorder, start, i-1);
        return node;
    }
}


// Your code here along with comments explaining your approach