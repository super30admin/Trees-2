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

/** Algorithm :
Inorder : left root right
Postorder : left right root 

postorder will give last element as root of tree
use inorder to locate the root element. left part is left subtree and right part is right subtree

TC : O(n) 
SC : O(n)
**/

//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
         if(inorder.length == 0 || postorder.length == 0) return null;
        
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        int index = -1;
        
        for(int i = 0; i < postorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        
        int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length-1 );
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length );
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;
    }
}