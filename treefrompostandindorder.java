/* Definition for a binary tree node.
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
        if(postorder.length == 0)
            return null;
        if(postorder.length == 1)
            return new TreeNode(postorder[0]);
        return helper(postorder.length-1, 0, inorder.length-1, postorder, inorder);
    }
    public TreeNode helper( int postend, int instart, int inend, int[] postorder, int[] inorder) {
        if(postend<0 || instart>inend)
            return null;
        TreeNode node = new TreeNode(postorder[postend]);
        int index=0;
        for(int i=instart;i<=inend;i++) {

            if(inorder[i] == node.val) {
                index=i;
                break;
            }
        }
        node.left = helper(postend - 1 - inend + index, instart, index-1, postorder, inorder);
        node.right = helper(postend-1, index+1, inend, postorder, inorder);
        return node;
    }
}