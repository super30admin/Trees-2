// Time Complexity : O(n) - For iterating over the elements of post order array
// Space Complexity : O(n) - For using extra space in the form of arrays
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Initially and had to see today's solution of binary tree from inorder and preorder and then got idea for this problem


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // base case
        if(postorder.length == 0){
            return null;
        }
        //Initializing index to be -1
        int index = -1;
        
        //Initializing root to be the last value of postorder array
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        // Searching for indecx of root in inorder array
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] ==  root.val){
                index = i;
                break;
            }
        }
        
        //Creating left and right array after root and index has been finalized
        
        int[] inleft = Arrays.copyOfRange(inorder, 0, index);
        int[] inright = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        int[] posleft = Arrays.copyOfRange(postorder, 0, index );
        int[] posright = Arrays.copyOfRange(postorder, index, postorder.length - 1);
        
        // calling left and right of tree recursively
        root.left = buildTree(inleft,posleft);
        root.right = buildTree(inright,posright);
        
        // returning the answer
        return root;
        
        
        
    }
}