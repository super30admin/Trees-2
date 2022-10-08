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
//Time Complexity: O(NM) //Postorder + inorderlength
//Space Complexity: O(N + M).
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0) return null;
        
        int rootVal = postorder[postorder.length-1];
        int index = 0;
        TreeNode root = new TreeNode(rootVal);
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == rootVal){
                index = i;
            }
        }
        
        int[] inorderleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inorderright = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] postorderleft = Arrays.copyOfRange(postorder, 0, index);
        int[] postorderright = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        root.left = buildTree(inorderleft, postorderleft);
        root.right = buildTree(inorderright, postorderright);
        
        
        return root;
    }
}