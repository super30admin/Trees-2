// Time Complexity : O(n^2) : Traversing the every node once and finding inorder for each postorder element
// Space Complexity : O(n^2) - For every level, we use n space and there can be atmost n levels 

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
     
         // Empty tree as input
        if (postorder.length == 0 || inorder.length == 0){
            return null;
        }
        
        // The root of binary tree always lies in the last index for the postorder traversal 
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        // Iterate and check the root index from the inorder list
        // Based on that we get the left sub tree and right sub tree
        int inorderIndex =  0;
        for (int i = 0; i < inorder.length ; i ++ ){
            if (inorder[i] == root.val){
                inorderIndex = i;
            }
        }
        
        // Compute the sub problems
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, inorderIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder,inorderIndex + 1 , inorder.length);
        
        
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, inorderIndex);
        int[] rightPostorder = Arrays.copyOfRange(postorder, inorderIndex , postorder.length - 1);
        
        
        // Recursively create the left and right sub trees 
        root.left = buildTree( leftInorder , leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        
        
        return root;
    }
}