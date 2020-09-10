/*
 * #106. Construct Binary Tree from Inorder and Postorder Traversal
 * 
 * Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

inorder = [9,3,15,20,7]
postorder = [9,15,7,20,3]

Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
   
 */


/*
 * Time Complexity: O (N*N) -> O (N^2) // N - Traverse all nodes of a tree while constructing tree
 * 									   // N - For each node, traverse through N or N-1 or N-2 etc elements in a postorder array to find root for every recursive call
 * 
 * Space Complexity: O (N) + O (N*M) -> O (N*M) // N - Recursive stack space to store 'N' nodes of a tree
 * 							 		// (N*M) - total space for creating copy of arrays for each node of a tree in every recursive call
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.trees2;

import java.util.Arrays;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}


public class ConstructBTInPost {
public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        // Base condition
        if(inorder.length == 0 || postorder.length == 0){
            return null; // Do nothing
        }
        
        // Find the root element from postorder array for every recursive call
        // Initially, we know the root is last element in postorder array
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        
        // Find the index of root element in inorder array for every recursive call
        int index = -1; // Initialize the index
        
        // For 1 node, this will run O(N) times
        // For N nodes, this will run O(N*N) = O(N^2)
        // Time Complexity: O (N^2)
        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == root.val){
                index = i;
                break;
            }
        }
        
        // Find the left subtree size and right subtree size in inorder array for every recursive call
        int leftSize = index - 0;
        int rightSize = inorder.length - 1 - index; // We are just using leftSize in code
        
        // Create the 4 arrays as a copy of respective original array for every recursive call
        // inorder left, inorder right, postorder left and postorder right 
        
        // e.g: inLeft = (inorder, 0, 1) -> 1 is exclusive, last index is exclusive
        // We are dividing the given problems into smaller subproblems
        int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
        int[] postLeft = Arrays.copyOfRange(postorder, 0, leftSize);
        
        int[] inRight = Arrays.copyOfRange(inorder, index+1, inorder.length);
        int[] postRight = Arrays.copyOfRange(postorder, leftSize, postorder.length-1);
        
        // Now, apply the recursion on both left and right arrays (for inorder and postorder both) to build a tree
        root.left = buildTree(inLeft, postLeft);
        root.right = buildTree(inRight, postRight);
        
        // return root (whole binary tree)
        return root;               
    }
    
}
