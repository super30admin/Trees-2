//Time Complexity : O(n) n is the total number of nodes in the tree
//Space Complexity : O(h) h is the height of the tree
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

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
        if(postorder == null || postorder.length == 0)  return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int index = -1;
        
        for(int i = 0;i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        int postleft[] = Arrays.copyOfRange(postorder, 0, index);
        int postright[] = Arrays.copyOfRange(postorder, index, postorder.length-1);
        
        int inleft[] = Arrays.copyOfRange(inorder, 0, index);
        int inright[] = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(inleft, postleft);
        root.right = buildTree(inright, postright);
        
        return root;
    }
}
