// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

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
    int index;
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> indexes;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        this.index = 0;
        this.indexes = new HashMap();
        for(int i = 0; i < inorder.length; i++) indexes.put(inorder[i], i);
        return buildTree(0, preorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if(left > right || index == preorder.length) return null;
        int rootIndex = indexes.get(preorder[index]);
        if(rootIndex < left || rootIndex > right) return null;
        TreeNode root = new TreeNode(preorder[index++]);
        root.left = buildTree(left, rootIndex - 1);
        root.right = buildTree(rootIndex + 1, right);
        return root;
    }
}