/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Yes

**/
class Solution 
{    
    Map<Integer,Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) 
    {
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);
        
        
        return buildTreeHelper(0,inorder.length -1,inorder, postorder, 0, postorder.length -1);
    }
    
    private TreeNode buildTreeHelper(int inStart, int inEnd, int[] inorder, int[] postorder, int postStart, int postEnd)
    {
        if(inStart > inEnd || postStart > postEnd)
            return null;
        
        int postOrderValue = postorder[postEnd];
        
        TreeNode treenode = new TreeNode(postOrderValue);
        
        int inorderIndex = map.get(postOrderValue);
        
        int leftElem = inorderIndex - inStart -1;
      
        treenode.left = buildTreeHelper(inStart, inorderIndex-1, inorder, postorder, postStart, postStart + leftElem);
        treenode.right = buildTreeHelper(inorderIndex+1, inEnd, inorder, postorder, postStart+ leftElem + 1, postEnd-1);

        
        return treenode;
    }
    
}