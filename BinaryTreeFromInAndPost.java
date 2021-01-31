/**
Leetcode: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

106. Construct Binary Tree from Inorder and Postorder Traversal

**/

class Solution 
{

    Map<Integer, Integer> inorderMap = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        
        for(int i=0; i< inorder.length; i++)
            this.inorderMap.put(inorder[i], i);
            
        return createBinaryTree(inorder, postorder, 0, inorder.length -1, 0, postorder.length -1);
            
        
    }
    
    private TreeNode createBinaryTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)
    {
    
        if( inStart > inEnd || postStart > postEnd)
            return null;
            
        int rootValue = postorder[ postEnd];
        
        TreeNode root = new TreeNode(rootValue);
        
        int indexInorder = this.inorderMap.get(rootValue);
        
        int leftTreeSize = indexInorder - inStart;
        
        int rightTreeSize = inEnd - indexInorder;
        
        root.left = createBinaryTree(inorder, postorder, inStart, indexInorder-1, postStart, postStart + leftTreeSize - 1);
       
        root.right = createBinaryTree(inorder, postorder, indexInorder + 1, inEnd, postEnd - rightTreeSize, postEnd -1);
        
        return root;
    }
    
}