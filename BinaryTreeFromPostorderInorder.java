package binaryTrees;

import java.util.Arrays;
import java.util.HashMap;
/**
 * Postorder: left->right->root
 * Inorder: left->root->right
 * Approach: Split left subtree elements and right subtree elements and repeatedly perform the buildtree function
 */
public class BinaryTreeFromPostorderInorder {

	public static void main(String[] args) {
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		
		buildTree(inorder, postorder);
		buildTreeOptimized(inorder, postorder);
	}
	
	
	/**
	 * Time: O(n^2) For every element, a corresponding, root is found in a loop
	 * Space: O(n) For every element, four sub arrays are used
	 * Leetcode accpeted: yes
	 * Problems faced: No
	 */

	private static TreeNode buildTree(int[] inorder, int[] postorder) {
		 if(postorder.length == 0) return null;
			
		 	//Last element is the root in post order traversal
			TreeNode root = new TreeNode(postorder[postorder.length-1]);
			int index = 0;
			
			//Find the index of root from inorder
			for(int i=0; i<inorder.length; i++) {
				if(inorder[i] == root.val) {
					index = i;
				}
			}
			
			//Split inorder traversal of left subtree and right subtree
			int[] inleft = Arrays.copyOfRange(inorder, 0, index);
			int[] inright = Arrays.copyOfRange(inorder, index+1, inorder.length);
			
			//Split postorder traversal of left subtree and right subtree
			int[] postleft = Arrays.copyOfRange(postorder, 0, index);
			int[] postright = Arrays.copyOfRange(postorder, index, postorder.length-1);
			
			 //Append the root-left and root-right with corresponding nodes
			root.left = buildTree(inleft, postleft);
		    root.right = buildTree(inright, postright);
		    return root;
	}
	
	/**
	 * Approach: Optimized just using indices of the sub arrays
	 * Time: O(n)
	 * Space: O(n) A single HashMap
	 * @param inorder
	 * @param postorder
	 * @return
	 */
	private static TreeNode buildTreeOptimized(int[] inorder, int[] postorder) {
		if(postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0) return null;
		
		 //Store inorder elements in Hashmap with index as the value in order to retrieve position of an element in O(1) time
		 HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();	 
		 for(int i=0; i<inorder.length; i++) {
			 map.put(inorder[i], i);
		 }
		 return helper(0, inorder.length-1, postorder, 0, postorder.length-1, map);
	}

	private static TreeNode helper(int instart, int inend, int[] postorder, int poststart, int postend, HashMap<Integer, Integer> map) {
		//Base case
		if(poststart > postend) return null;
		
		//First Element in preorder traversal is always root
		 TreeNode root = new TreeNode(postorder[postend]);
		 int rootIndex = map.get(root.val);
		 
		//Size of left subtree
		 int leftSize = rootIndex - instart;
		
		 root.left = helper(instart, rootIndex-1, postorder, poststart, poststart+leftSize-1, map);
		 root.right = helper(rootIndex+1, inend, postorder, poststart+leftSize, postend-1, map);
		 
		 return root;
	}

}
