/**
## Problem1 (https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)
 
Time Complexity :   O (N) 
Space Complexity :  O (N) 
Did this code successfully run on Leetcode :    Yes (106. Construct Binary Tree from Inorder and Postorder Traversal)
Any problem you faced while coding this :       No
 */

 // Input: inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
class Solution {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int post_idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // base case
        if(inorder == null || inorder.length == 0)
            return null;
        
        // to store inorder data and index
        for(int i =0; i< inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        // root will be at last position in Postorder
        post_idx = postorder.length - 1;
        return helper(postorder, 0, inorder.length - 1);
    }
     
    public TreeNode helper(int[] postorder, int start, int end) {
        // when start and end crosses, return null
        if(start>end)
            return null;
        
        // create a node from rootval
        int rootVal = postorder[post_idx];
        TreeNode root = new TreeNode(rootVal);   
        
        int rootIdx = map.get(rootVal);
        post_idx--;
        
        // recursively call left and right nodes
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        
        return root;
    }
}