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
        //base
        if(postorder.length==0) return null;
        //logic
        int rootVal = postorder[postorder.length-1];
        int rootIdx = -1; //idx in inorder array
        for(int i=0;i<inorder.length;i++){
            if(rootVal==inorder[i]){
                rootIdx = i;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int leftSize = rootIdx;
        int[] postLeft = Arrays.copyOfRange(postorder, 0, leftSize);
        int[] postRight = Arrays.copyOfRange(postorder, leftSize, postorder.length-1);
        //left
        root.left = buildTree(inLeft, postLeft);
        //right
        root.right = buildTree( inRight, postRight);

        return root;

    }
}