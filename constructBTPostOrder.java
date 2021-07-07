/*
Author: Akhilesh Borgaonkar
Problem: LC 106. Construct Binary Tree from Inorder and Postorder Traversal (Trees-2)
Approach: Using recursive approach here to build the binary tree. First, find the root in inorder array and then we get the left sub-tree to the
    left of the root value and right sub-tree to the right of the root node. Call the buildTree method recursively on the sub-trees. 
Time Complexity: O(n^2) where n is number of total nodes in the resultant Binary Tree.
Space complexity: O(n) where n is number of total nodes in the resultant Binary Tree.
LC verified.
*/

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int postLen = postorder.length;
        if(postLen == 0)
            return null;
        TreeNode root = new TreeNode(postorder[postLen-1]);
        int index = 0;
        
        for(int i=0; i<inorder.length; i++){
            if(inorder[i]==root.val){
                index = i;
                break;
            }
        }
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postLen-1);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}