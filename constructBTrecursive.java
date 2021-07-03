//time complexity O(n)
//space complexity O(h * n) => O(n^2) because in worst case scenario height of the tree is gonna be n

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int iIndex = -1;
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                iIndex = i;
            }
        }
        int[] preLeft = Arrays.copyOfRange(preorder, 1, iIndex + 1);
        int[] preRight = Arrays.copyOfRange(preorder, iIndex + 1, preorder.length);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, iIndex);
        int[] inRight = Arrays.copyOfRange(inorder, iIndex +1, inorder.length);
        root.left = buildTree(preLeft, inLeft);
        root.right = buildTree(preRight, inRight);
        return root;
    }
}
