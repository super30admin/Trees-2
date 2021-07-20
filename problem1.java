//time- O(N)
//space- O(N)

public class BinaryTreeConstruction {
	Map<Integer, Integer> inorderIndexMap;
	int postorderIndex;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || postorder.length == 0) {
			return null;
		}

		postorderIndex = postorder.length - 1;
		inorderIndexMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}

		return helper(postorder, 0, postorder.length - 1);
	}

	private TreeNode helper(int[] postorder, int start, int end) {
		// Base Case
		if (start > end) {
			return null;
		}

		// Create Node
		int val = postorder[postorderIndex--];
		TreeNode node = new TreeNode(val);
		// Right Subtree
		node.right = helper(postorder, inorderIndexMap.get(val) + 1, end);
		// Left SubTree
		node.left = helper(postorder, start, inorderIndexMap.get(val) - 1);

		return node;
	}

	public void printInorder(TreeNode root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.val + " ");
		printInorder(root.right);
	}
}
