//time complexity is O(N^2) as build tree is called twice recursively so two for loops (Letme know in comments if I'm right)
//Space complexity is O(N)
//This solution is accepted in leetcode

import java.util.Arrays;
import java.util.HashMap;

public class BigN44ConstructTreeInAndPostUsingHashMap {
	int index = 0;
	HashMap<Integer, Integer> map = new HashMap<>();
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		// edge case
		if (inorder.length == 0 || postorder.length == 0) {
			return null;
		}
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return helper(inorder,postorder);
	}
	private TreeNode helper(int[] inorder, int[] postorder) {
		int last = postorder.length - 1;
		index = map.get(postorder[last]);
		TreeNode node = new TreeNode(postorder[last]);
		int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] poLeft = Arrays.copyOfRange(postorder, 0, index);
		int[] poRight = Arrays.copyOfRange(postorder,index,postorder.length-1);
		node.left = buildTree(inLeft,poLeft);
		node.right = buildTree(inRight,poRight);
		return node;
	}
}
