// Time Complexity : O(n^2)
// Space Complexity : O(n^2)
// Did this code successfully run on Leetcode :yes 
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder == null || postorder.length == 0)
            return null;
        
        //find root in postorder
        int n = postorder.length;
        int rootVal = postorder[n-1];
        TreeNode root = new TreeNode(rootVal);
        
        //find root in inorder
        int rootIdx = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == rootVal)
                rootIdx = i;
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, rootIdx);
        int[] inRight = Arrays.copyOfRange(inorder, rootIdx+1, n);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, rootIdx);
        int[] postRight = Arrays.copyOfRange(postorder, rootIdx, n-1);
        
        //divide left and right subtree
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}