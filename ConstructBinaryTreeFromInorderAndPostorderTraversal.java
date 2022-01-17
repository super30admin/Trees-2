package trees2;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) { this.val = val; }
		 TreeNode(int val, TreeNode left, TreeNode right) {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	}
	
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (null == inorder || null == postorder) {
			return null;
		}
		return buildTree(inorder, 0, inorder.length - 1, postorder,  0, postorder.length - 1);
	}

	public TreeNode buildTree(int[] inorder, int inL, int inR,
							  int[] postorder, int postL, int postR) {
		if (inL > inR) {
			return null;
		}
		if (inL == inR) {
		  return new TreeNode(inorder[inL]);
		}

		TreeNode node = new TreeNode(postorder[postR]);
		int idx = inL;  
		for (int i = inL; i <= inR; i++) {
			if (inorder[i] == postorder[postR]) {
				idx = i;
				break;
			}
		}
		node.left = buildTree(inorder, inL, idx - 1, postorder, postL, postL + (idx - 1 - inL));
		node.right = buildTree(inorder, idx + 1, inR, postorder, postL + (idx - 1 - inL) + 1, postR - 1);
		return node;
	}
}
