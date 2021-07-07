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

         // Time Complexity : O(No. of treenodes )
// Space Complexity : O(No. of treenodes)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/*
1.For getting the index of root in inorder, we use HashMap.
2.We use helper function, with the range of inorder we need for that subtree(left or right)
2.Based on the map value, we rewrite the left and right function.
*/
    
    int postIndex;
    HashMap<Integer, Integer> hm;
    
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder.length == 0 || postorder.length == 0) return null;
        
        postIndex = postorder.length-1;
        hm = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
           hm.put(inorder[i],i);
        }
        
        return helper(inorder, postorder, 0, postorder.length-1);
    
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end){
        //base
        if(start>end || postIndex<0) return null;
        
        //logic
        TreeNode root = new TreeNode(postorder[postIndex]);
        int inIndex = hm.get(postorder[postIndex]);
        postIndex--;
        root.right = helper(inorder, postorder, inIndex+1 , end);     
        root.left = helper(inorder, postorder, start, inIndex-1);
        return root;
    }
        
    
}