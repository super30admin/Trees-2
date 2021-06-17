// Time Complexity : O(N)
// Space Complexity : O(N) // hashmap size 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Place inorder array into hashmap with index as value.
 * 2. take postorder start end index element as root.
 * 3. find index of element in map. post order beside the last element is right tree lement so process right first.
 * 4. iterate right part as right tree and left part of index as left tree.
 */

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePostorderInorder {
	Map<Integer, Integer> map;
	int postIndex;

	public TreeNode buildTree( int[] inorder,int[] postorder) {
		map = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		postIndex= postorder.length-1;
		return helper(postorder,0,inorder.length-1);
	}
	
	private TreeNode helper(int[] postorder,int start,int end) {
		
		//condition
		if(start>end) return null;
		//logic
		int rootValue = postorder[postIndex--];
		int inIndex = map.get(rootValue);
		TreeNode root= new TreeNode(rootValue);
		
		root.right=helper(postorder,inIndex+1,end);
		root.left= helper(postorder,start,inIndex-1);
		return root;		
	}
	
	public static void main(String[] args) {
		TreeNode root = new ConstructBinaryTreePostorderInorder().buildTree(new int[] {9,3,15,20,7}, new int[] {9,15,7,20,3}) ;
		
		printPostorder(root);
		System.out.println();
		printInorder(root);
	}
	
	private static void printInorder(TreeNode root) {
		//condition
		if(root==null) return;
		printInorder(root.left);
		//logic
		System.out.print(root.val+"..");
		printInorder(root.right);
	}
	
	private static void printPostorder(TreeNode root) {
		//condition
		if(root==null) return;
		printPostorder(root.left);
		printPostorder(root.right);
		//logic
		System.out.print(root.val+"..");
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
