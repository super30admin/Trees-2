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
        if(postorder == null || postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int idx = -1;
        
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == root.val){
                idx = i;
                break;
            }
        }
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] poLeft = Arrays.copyOfRange(postorder, 0,idx);
        int[] poRight = Arrays.copyOfRange(postorder, idx, postorder.length-1);
        
        root.left = buildTree(inLeft, poLeft);
        root.right = buildTree(inRight, poRight);
        
        return root;
    }
}

//TC: O(N)
