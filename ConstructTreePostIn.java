
// Time Complexity: For Recursive, O(n).
// Space Complexity: For Recursive, O(n) - Recursion Stack Space + O(n) - Ausiliary Space
// Did this code successfully run on Leetcode: Yes
// Any problems faced: No

import java.util.Arrays;

public class ConstructTreePostIn {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	class RecursiveSolution {
		public TreeNode buildTree(int[] inorder, int[] postorder) {
			if (inorder.length == 0 || postorder.length == 0)
				return null;
			int index = -1;
			int r = postorder[postorder.length - 1];
			TreeNode root = new TreeNode(r);
			for (int i = 0; i < inorder.length; i++) {
				if (inorder[i] == r) {
					index = i;
					break;
				}
			}

			int[] inLeft = Arrays.copyOfRange(inorder, 0, index);
			int[] inRight = Arrays.copyOfRange(inorder, index + 1, inorder.length);
			int[] postLeft = Arrays.copyOfRange(postorder, 0, index);
			int[] postRight = Arrays.copyOfRange(postorder, index, postorder.length - 1);

			root.left = buildTree(inLeft, postLeft);
			root.right = buildTree(inRight, postRight);
			return root;
		}
	}
}
