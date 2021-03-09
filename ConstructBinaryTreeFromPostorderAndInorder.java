// TC - O(n), SC - O(n)

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
        // Sanity check
        if(postorder == null || postorder.length == 0){
            return null;
        }
        // create TreeNode with postorder[postorder.length-1], as in postorder root is at last place
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int idx = -1;
        // find root.val at inorder array
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                idx = i;
                break;
            }
        }
        // Left subtree in postorder array, we can find using index
        int[] postLeft = Arrays.copyOfRange(postorder, 0, idx);
        // Right subtree
        int[] postRight = Arrays.copyOfRange(postorder, idx, postorder.length-1);
        
        // Left subtree in inorder array
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        // Right subtree in inorder array
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        // finding root left and right parts    
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
        
    }
}