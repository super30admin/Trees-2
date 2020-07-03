//Time complexity is O(N^2) as build tree is called twice recursively so two for loops (Letme know in comments if I'm right)
//Space complexity is O(N)
//This solution is accepted in leetcode

import java.util.Arrays;

public class BigN44ConstructTreeInAndPostUsingloop {
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
		int index = 0;
		int last = postorder.length - 1;
		TreeNode node = new TreeNode(postorder[last]);
		for (int i = 0; i < inorder.length; i++) {
			if (inorder[i] == node.val) {
				index = i;
				break;
			}
		}
		int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
		int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
		int[] poLeft = Arrays.copyOfRange(postorder, 0, index);
		int[] poRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);
		node.left = buildTree(inLeft, poLeft);
		node.right = buildTree(inRight, poRight);
		return node;
	}
}
