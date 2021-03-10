// Time Complexity : O(n^2), n = no. of nodes of tree
// Space Complexity : O(2n + h)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if( inorder == null || inorder.length == 0) return null;
        
        int root = postorder[postorder.length -1];
        TreeNode tree = new TreeNode(root);
        int index = -1;
        for(int i = 0; i< inorder.length;i++){
            if(inorder[i] == root) {
                index = i; break;
            }
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length -1);
        
        tree.left = buildTree(inLeft , postLeft);
        tree.right = buildTree(inRight, postRight);
        
        return tree;
    }
    
}
