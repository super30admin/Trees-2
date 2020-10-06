package com.javaDwarf.binaryTrees.leetcode.construction;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _106_ConstructBinaryTreefromInorderandPostorderTraversal {

	public static void main(String[] args) {
		
		int[] in = {9,3,15,20,7};
		int[] post = {9,15,7,20,3};
		
		TreeNode x = new _106_ConstructBinaryTreefromInorderandPostorderTraversal().buildTree(in, post);
		System.out.println(x);

	}

    public static int current = -1;
	public TreeNode buildTree(int[] inorder, int[] postorder){
		current = inorder.length-1;
		return buildTree(inorder, postorder,0,inorder.length-1);
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder, int start, int end){

		if(start > end) return null;
		
		TreeNode root = new TreeNode(postorder[current]);
		System.out.println(postorder[current]);
		
		int mid = -1;
		for(int i=start; i<=end; i++) {
			if(postorder[current] == inorder[i]) {
				mid = i;
				break;
			}
		}
		
		current--;
		root.right = buildTree(inorder, postorder,  mid+1,end);
		root.left = buildTree(inorder, postorder, start, mid-1);
		
		return root;
	}
}
