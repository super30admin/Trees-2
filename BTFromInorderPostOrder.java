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
//Time Complexity: O(n*n)
//Space Complexity: O(n*n)
class Solution {
    int rootIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder ==null || postorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        for(int i=0;i<inorder.length;i++) {
            if(postorder[postorder.length-1] == inorder[i]){
                rootIndex=i;
                break;
            }
        }
        int lengthRight = inorder.length -1-rootIndex;
        int[] postleft = Arrays.copyOfRange(postorder, 0 ,(postorder.length-lengthRight-1));
        int[] postRight = Arrays.copyOfRange(postorder, (postorder.length-1-lengthRight), postorder.length-1);
        int[] inleft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);

        root.left = buildTree(inleft,postleft);
        root.right = buildTree(inRight,postRight);
        return root;
    }
}