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
        if(postorder.length == 0|| postorder == null) return null;
        int rootNo = postorder[postorder.length-1];
        int rootIdx = 0;
        TreeNode root = new TreeNode(rootNo);
        //Find root in inorder
        for(int i = 0; i<inorder.length;i++){
            if(inorder[i] == root.val){
                rootIdx = i;
            }
        }
        int[] postleft = Arrays.copyOfRange(postorder,0,rootIdx);
        int[] postRight = Arrays.copyOfRange(postorder,rootIdx,postorder.length-1);
        int[] inLeft = Arrays.copyOfRange(inorder,0,rootIdx);
        int[] inright = Arrays.copyOfRange(inorder,rootIdx+1,postorder.length);

        root.left = buildTree(inLeft,postleft);
        root.right = buildTree(inright,postRight);
        return root;
    }
}