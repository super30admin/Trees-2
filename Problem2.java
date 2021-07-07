// Time Complexity :
//      n is the number of elements
//      buildTree() - O(n*n)
//      
// Space Complexity :
//      buildTree() - O(n)
//
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;
        
        return helper(inorder, postorder);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder)
    {
        if(postorder.length == 0)
            return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        int idx = 0;
        
        for(int i=0; i<inorder.length; ++i)
        {
            if(inorder[i] == root.val)
            {
                idx = i;
                break;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, idx);
        int[] inRight = Arrays.copyOfRange(inorder, idx+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, idx);
        int[] postRight = Arrays.copyOfRange(postorder, idx, postorder.length-1);
        
        root.left = helper(inLeft, postLeft);
        root.right = helper(inRight, postRight);
        
        return root;
    }
}