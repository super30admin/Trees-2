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
// Time Complexity : O(n2)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english
// find the root node from the inorder list, then separate out the left, right part of both inorder and preorder list
// and do the same for left and right tree recursively
// Your code here along with comments explaining your approach
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // null
        if ( inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
            return null;
        // find root
        int n = postorder.length;
        int rootValue = postorder[n-1];
        TreeNode rootNode = new TreeNode(rootValue);
        int idx = -1;
        for(int i = 0; i< inorder.length; i++){
            if(inorder[i] == rootValue){
                idx = i;
            }
        }
        int [] inLeft = Arrays.copyOfRange(inorder,0,idx);
        int [] inRight = Arrays.copyOfRange(inorder,idx+1,inorder.length);
        int [] postLeft = Arrays.copyOfRange(postorder,0,n-(inLeft.length+1));
        int [] postRight = Arrays.copyOfRange(postorder,n-(inLeft.length+1),n-1);
        rootNode.left = buildTree(inLeft, postLeft);
        rootNode.right = buildTree(inRight, postRight);
        return rootNode;
    }
}