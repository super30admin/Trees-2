// Time Complexity : O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Doubt as to why we perform recursion on the right subtree first and then the left subtree

import java.util.*;

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2() {
	}

	TreeNode2(int val) {
		this.val = val;
	}

	TreeNode2(int val, TreeNode2 left, TreeNode2 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

class Construct_BT {
	HashMap<Integer, Integer> result;
	int postIdx;

	public TreeNode2 buildTree(int[] inorder, int[] postorder) {
		postIdx = inorder.length - 1;
		result = new HashMap<>();
		for (int i = 0; i < inorder.length; i++) {
			result.put(inorder[i], i);
		}
		return helper(postorder, inorder, 0, inorder.length - 1);
	}

	private TreeNode2 helper(int[] postorder, int[] inorder, int start, int end) {
		// base
		if (start > end)
			return null;

		// logic
		TreeNode2 root = new TreeNode2(postorder[postIdx]);
		int inorderIdx = result.get(root.val);
		postIdx--;
		root.right = helper(postorder, inorder, inorderIdx + 1, end);
		root.left = helper(postorder, inorder, start, inorderIdx - 1);
		return root;
	}
}