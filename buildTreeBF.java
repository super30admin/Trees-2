import java.util.Arrays;

// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//brute force
class Solution {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //base case to check if the array is empty
        if(postorder == null || postorder.length == 0)
            return null;
        
        int n = inorder.length;
        int rootVal = postorder[n - 1];
        TreeNode root = new TreeNode(rootVal);
 
        //find the index of the root in the inorder array
        int rootIdx = 0;
        for(int i = 0; i < inorder.length; i++)
            if(inorder[i] == rootVal)
                rootIdx = i;
        
        //split the arrays 
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx + 1, n);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] postRight = Arrays.copyOfRange(postorder, rootIdx, n - 1);
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
        
    }
}












