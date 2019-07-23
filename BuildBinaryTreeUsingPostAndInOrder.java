//idea:  recrusive solution.
//postorder means  left right root and inorder means left root right .
//therefore last element in postorder is root of BT. WE will search this root in inorder to find its left and right element .
//so in inorder once root element is found then all  element to its left are left of root and all element to its right are right of root
//time complexity o(n)
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:yes array index out of bound

import java.util.Arrays;



public class BuildBinaryTreeUsingPostAndInOrder {

	
	//class TreeNode contains data, left and right node
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			val = value;
		}
	}

	//method to build binary tree using postorder and inorder
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		//null check
		if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0)
			return null;

		//postorder last element is root .so creating root first
		TreeNode root = new TreeNode((postorder[postorder.length - 1]));
		//if post order lenght is 1 then return root
		if (postorder.length == 1)
			return root;
		int rootindex = -1;
		
		//check root in inorder and keep node of index of root in inorder 
		//in inorder the element on left side of root are left child and elements on right side of root are right child
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == postorder[postorder.length - 1]) {
				rootindex = i;
				break;
			}
		}
		
		//inorder left child are element from 0 till index of root. and right means index+1 (except root)till end.
		//postorder left means element from 0 till index of root and right means from index till length -1. (except root)
		int[] inordersubleft = Arrays.copyOfRange(inorder, 0, rootindex);
		int[] inordersubright = Arrays.copyOfRange(inorder, rootindex + 1, inorder.length);
		int[] postordersubleft = Arrays.copyOfRange(postorder, 0, rootindex);
		int[] postordersubright = Arrays.copyOfRange(postorder, rootindex, postorder.length - 1);
		root.left = buildTree(inordersubleft, postordersubleft);
		root.right = buildTree(inordersubright, postordersubright);

		return root;
	}
	 /* This funtcion is here just to test buildTree() */
    static void printInorder(TreeNode node) 
    { 
        if (node == null) 
            return; 
  
        /* first recur on left child */
        printInorder(node.left); 
  
        /* then print the data of node */
        System.out.print(node.val + " "); 
  
        /* now recur on right child */
        printInorder(node.right); 
    } 

	public static void main(String[] args) {
		 { 
		       
		        int in[] = new int[] { 9,3,15,20,7}; 
		        int post[] = new int[] { 9,15,7,20,3 }; 
		        int len = in.length; 
		        TreeNode root =buildTree(in, post);
		  
		        // building the tree by printing inorder traversal 
		        System.out.println("Inorder traversal of constructed tree is : "); 
		        printInorder(root); 
		    } 

	}

}
