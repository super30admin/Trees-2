package Q_106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal;

import java.util.Arrays;
import java.util.HashMap;

//Given inorder and postorder traversal of a tree, construct the binary tree.
//
//Note:
//You may assume that duplicates do not exist in the tree.
//
//For example, given
//
//inorder = [9,3,15,20,7]
//postorder = [9,15,7,20,3]
//Return the following binary tree:
//
//    3
//   / \
//  9  20
//    /  \
//   15   7

//Time Complexity  : O(n)  
//Space Complexity : O(n)

public class Solution {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	
	public HashMap<Integer, Integer>createMap(int[] inorder) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i < inorder.length;i++) {
			map.put(inorder[i], i);
		}
		return map;
	}

	public TreeNode helper(int[] inorder, int[] postorder) {
		//base case
		if(inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		
		
		//create Map
		HashMap<Integer, Integer> map = createMap(inorder);
		TreeNode root = new TreeNode(postorder[postorder.length-1]);
		int rootValue = postorder[postorder.length-1];
		int index = map.get(rootValue);
		
		int[] leftInorder = Arrays.copyOfRange(inorder, 0, index);
		int[] rightInorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
		int[] leftPostorder = Arrays.copyOfRange(postorder, 0, index);
		int[] rightPostorder = Arrays.copyOfRange(postorder, index, postorder.length-1);
		
		root.left = helper(leftInorder, leftPostorder);
		root.right = helper(rightInorder, rightPostorder);
		
		
		
		return root;
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, postorder);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		System.out.println(s.buildTree(inorder, postorder));
		
		

	}

}
