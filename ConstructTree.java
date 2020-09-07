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
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no 


// Your code here along with comments explaining your approach

/*
    The root can be found at the end of postorder array.
    We build recursive solution and pass the reduced in order and post order arrays.

*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(postorder.length == 0) return null;
        
        int index = -1;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        //System.out.println(Arrays.toString(postorder));
        
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        
        
        int[] preLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] preRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        
        root.left = buildTree(inLeft, preLeft);
        root.right = buildTree(inRight, preRight);
        /*
        System.out.println(Arrays.toString(preLeft));
        System.out.println(Arrays.toString(preRight));
        System.out.println(Arrays.toString(inLeft));
        System.out.println(Arrays.toString(inRight));*/
        
        return root;
        
    }
}