package trees_2;

/*
Idea : 1. From the post-order array, we know that last element is the root. We can find the root in in-order array.
	   2. Then we can identify the left and right sub-trees of the root from in-order array.
	   3. Using the length of left sub-tree, we can identify left and right sub-trees in post-order array. 
	      Recursively, we can build up the tree.  
Time Complexity : O(n) where n is the number of nodes
Space Complexity : O(n) as we have traverse all the tree nodes.
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
*/


public class BinaryTreeFromInorderAndPostorder {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		int postStart = 0;
		int postEnd = postorder.length - 1;
		int inStart = 0;
		int inEnd = inorder.length - 1;

		return construct(inorder, inStart, inEnd, postorder, postStart, postEnd);
	}

	public TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (postStart > postEnd || inStart > inEnd) {
			return null;
		}

		int val = postorder[postEnd];
		TreeNode root = new TreeNode(val);

		// find parent element index from inorder
		int k = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (val == inorder[i]) {
				k = i;
				break;
			}
		}

		// k is not the length, it it need to - (inStart + 1) to get the length
		root.left = construct(inorder, inStart, k - 1, postorder, postStart, postStart + k - (inStart + 1));
		
		// postStart + k - inStart = postStart + k - (inStart + 1) + 1
		root.right = construct(inorder, k + 1, inEnd, postorder, postStart + k - inStart, postEnd - 1); 

		return root;
	}
}
