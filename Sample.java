import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

/**
 * Similar to inorder and preorder method of constructing the BST.
 * The only condition is to iterate from the last index and construct
 * root.right frist and then root.left.
 *
 */
class Solution {
	int postIndex;
	Map<Integer, Integer> map = new HashMap<>();

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		postIndex = postorder.length - 1;
		for (int i = 0; i < inorder.length; i++)
			map.put(inorder[i], i);
		return helper(postorder, 0, postorder.length - 1);
	}

	public TreeNode helper(int[] postorder, int left, int right) {
		if (left > right)
			return null;

		int val = postorder[postIndex];
		TreeNode root = new TreeNode(val);
		postIndex--;
		root.right = helper(postorder, map.get(val) + 1, right);
		root.left = helper(postorder, left, map.get(val) - 1);
		return root;
	}
}