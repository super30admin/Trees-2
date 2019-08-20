package binaryTrees;

import java.util.Arrays;
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
	}

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

}
