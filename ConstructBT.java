/*
106. Construct Binary Tree from Inorder and Postorder Traversal - MEDIUM
https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

TC: O(n) - all elements in the post/in order array
SC: O(n^2) - stack space + new arrays

Approach: The last element in the postorder traversal is the root of the tree.
All elements to the left of this node in inorder forms the left subtree,
and all elements to the right of this node in inorder forms the right subtree.
Recurse till all elements in the array are visited
*/

import java.util.Arrays;

public class ConstructBT {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        
        int index = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == root.val) {
                index = i;
                break;
            }
        }
        
        if (index == -1) {
            return null;
        }
        
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
        int[] postRight = Arrays.copyOfRange(postorder, index, inorder.length-1);
        
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        return root;       
    }
}
