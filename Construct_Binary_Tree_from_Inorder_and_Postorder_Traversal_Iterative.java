// 106. Construct Binary Tree from Inorder and Postorder Traversal - https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Time Complexity : O(N^2)
// Space Complexity : O(NH)
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0)
            return null;
        
        // find root in postorder
        int n = postorder.length;
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);
        
        // search root in inorder
        int rootIdx = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==rootVal)
                rootIdx=i;
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, n);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] postRight = Arrays.copyOfRange(postorder, rootIdx, n-1);
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}