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
// Time Complexity : O(n^2) 
// Space Complexity :O(n^2) 
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder==null || postorder.length ==0) return null;
        TreeNode root=new TreeNode(postorder[postorder.length-1]);
        int index=-1;
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val) {
                index=i;
                break;
            }
        }
        int[] postorderLeft= Arrays.copyOfRange(postorder, 0,index);
        int[] postorderRight=Arrays.copyOfRange(postorder, index,postorder.length-1);
        int[] inorderLeft=Arrays.copyOfRange(inorder, 0,index);
        int[] inorderRight=Arrays.copyOfRange(inorder, index+1, inorder.length);
        root.left=buildTree(inorderLeft, postorderLeft);
        root.right=buildTree(inorderRight, postorderRight);
        return root;
        
        
    }
}