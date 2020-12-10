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
        
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1);
        
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end, int index){
        if(start > end){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[index]);
        int inRootIndex = start;
        
        while(postorder[index] != inorder[inRootIndex]){
            inRootIndex++;
        }
        
        root.right = helper(inorder, postorder, inRootIndex+1, end, index-1);
        root.left = helper(inorder, postorder, start, inRootIndex-1,  index-(end - inRootIndex)-1);
        
        return root;
        
        
    }
    
}