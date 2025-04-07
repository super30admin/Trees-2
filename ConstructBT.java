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
 * }`
 */`
class ConstructBT {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0)
            return null;
        int rootVal = postorder[postorder.length -1];
        int rootIdx = 0;

        for(int i=0; i<inorder.length; i++){
            if(rootVal == inorder[i]){
                rootIdx = i;
                break;
            }
        }

        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, inLeft.length);
        int[] postRight = Arrays.copyOfRange(postorder, inLeft.length, postorder.length-1);

        TreeNode tree = new TreeNode(rootVal);
        tree.left = buildTree(inLeft, postLeft);

        tree.right = buildTree(inRight, postRight);
        return tree;

     }
}