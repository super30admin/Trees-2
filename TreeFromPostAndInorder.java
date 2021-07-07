/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

  
// Time Complexity : O(N)
// Space Complexity : O(logN)  : recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, took a while to code the logic


// Your code here along with comments explaining your approach
// Postorder traversal : Left, Right, Root
// Inorder Traversal : Left, Root, Right
// We can identify the root element from postorder array. Search the position of the obtained root element
// in inorder array. Elements on left side of the obtained root element will form the left subtree.
// Elements on the right of obtained root node will form the right subtree. This operation will be performed
// recursively until all the elements are visited.

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length-1, postorder.length-1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postEnd) {
        //Base case
        if(inStart > inEnd || postEnd < 0) return null;
        
        //Logic
        TreeNode root = new TreeNode(postorder[postEnd]);
        // find the position of root in inorder array
        // elements on left of this position will form the left subtree
        // elements on the right of this position will form the right subtree
        int rootPos = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postEnd]) {
                rootPos = i;
                break;
            }
        }
        // forming left subtree recursively
        root.left = helper(inorder, postorder, inStart, rootPos-1, postEnd-1-(inEnd-rootPos));
        // forming right subtree recursively
        root.right = helper(inorder, postorder, rootPos+1, inEnd, postEnd-1);
        return root;
    }
}