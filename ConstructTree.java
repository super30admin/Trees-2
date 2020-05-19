// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


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
        
        //base case
        if(inorder.length==0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int index = 0;
        for(; index <inorder.length;index++)
        {
            if(inorder[index]==root.val) break;
        }
        
        int[] post_left = Arrays.copyOfRange(postorder,0,index);
        int[] post_right = Arrays.copyOfRange(postorder,index,postorder.length-1);
        int[] in_left = Arrays.copyOfRange(inorder,0, index);
        int[] in_right = Arrays.copyOfRange(inorder,index+1,inorder.length);
        
        root.left = buildTree(in_left,post_left);
        root.right = buildTree(in_right,post_right);
        
        return root;
    }
}