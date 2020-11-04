import java.util.HashMap;

//Construct Binary Tree by Pre-order and In-order using HAsh MAp 
public class ConstrutBinaryTree {

	HashMap<Integer, Integer> map;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder.length == 0 || inorder.length == 0) {
			return null;
		}

		map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, preorder, 0, inorder.length - 1);

	}

	private TreeNode helper(int[] inorder, int[] preorder, int start, int end) {
		// TODO Auto-generated method stub

		// base
		if (start >= end)
			return null;
		// logic
		TreeNode root = new TreeNode(preorder[0]);
		root.left = helper(inorder, preorder, start, map.get(root.val) - 1);
		root.right = helper(inorder, preorder, map.get(root.val) + 1, end);
		return root;
	}
}
