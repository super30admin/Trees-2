// Time Complexity : O(N) -> N = no of nodes (visiting all once)
// Space Complexity : O(H) -> H = height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder == null || postorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int index = -1;
        
        for(int i = 0; i < inorder.length; i++) {
            
            if(inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}