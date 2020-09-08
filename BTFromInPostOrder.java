// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// Recursion. Storage the index in map for inorder
// Used two indexes for inorder and 2 for postorder
// Last element of postorder is the root, so begin from the last
// and use the indexes to build the tree starting from the last in the postorder
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder ==null || inorder.length==0 || postorder ==null || postorder.length==0)
            return null;
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1); 
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int startIn, int endIn, int startPos, int endPos){
        
        if(startIn > endIn)
            return null;
            
        TreeNode root = new TreeNode(postorder[endPos]);
        int inOrderIndex = map.get(postorder[endPos]);
        int newIndex = inOrderIndex - startIn;
        
        root.left= helper(inorder, postorder, startIn, inOrderIndex-1, startPos, startPos+newIndex-1);
        root.right= helper(inorder, postorder, inOrderIndex+1, endIn, startPos+newIndex, endPos-1 );
        
        return root;
    }
}