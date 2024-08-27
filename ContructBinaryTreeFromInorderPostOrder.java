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
class ContructBinaryTreeFromInorderPostOrder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        if(n<=0) return null;
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = -1;
        for(int i=0;i<inorder.length;i++) {
            if(inorder[i] == rootVal) {
                rootIndex = i;
            }
        }
        int[] inorderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
        int[] inorderRight = Arrays.copyOfRange(inorder, rootIndex+1, inorder.length);
        int[] postorderLeft = Arrays.copyOfRange(postorder,0,inorderLeft.length);
        int[] postorderRight = Arrays.copyOfRange(postorder,inorderLeft.length,n-1);
        root.left = buildTree(inorderLeft,postorderLeft);
        root.right = buildTree(inorderRight,postorderRight);
        return root;
    }
}