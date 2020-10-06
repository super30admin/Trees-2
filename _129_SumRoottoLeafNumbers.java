package com.javaDwarf.binaryTrees.leetcode.dfs;

import java.util.LinkedList;

import com.javaDwarf.binaryTrees.leetcode.TreeNode;

public class _129_SumRoottoLeafNumbers {

	public static void main(String[] args) {

		TreeNode l1 = new TreeNode(1);
		TreeNode l2 = new TreeNode(5);
		TreeNode l3 = new TreeNode(1);
		TreeNode l4 = new TreeNode(6);

		l1.left = l2;
		l1.right = l3;

		l3.right = l4;

		int x = new _129_SumRoottoLeafNumbers().sumNumbers(l1);
		System.out.println(x);

	}

	public int sum = 0;
	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		this.sum = 0;
		//binaryTreePaths(root, new LinkedList<Integer>()); // works uses extra List to hold elements
		sumdfs(root, 0);
		return this.sum;
	}

	public void binaryTreePaths(TreeNode root, LinkedList<Integer> lc) {

		if(root.left == null && root.right == null) {
			String result = "";
			for(int i : lc) {
				result += i;	
			}
			result +=root.val;
			this.sum += Integer.parseInt(result);
			return;
		}

		lc.addLast(root.val);
		if(root.left!=null)
			binaryTreePaths(root.left,lc);
		if(root.right!=null)
			binaryTreePaths(root.right,lc);
		lc.removeLast();
	}
	
	public void sumdfs(TreeNode root,int currSum) {
		
		if( root == null) return;

		currSum = currSum *10 + root.val;  //since numbers are between 0-9
		if(root.left == null && root.right == null) {
			sum += currSum;
			return;
		}
		sumdfs(root.left,currSum);
		sumdfs(root.right,currSum);
	}
	
	

}
