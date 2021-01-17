import java.util.HashMap;

/*
 * The complexity of the algorithm is O(n) where n is no of elements.
 * Space complexity is O(n) where n is no of elements.
 */

public class ConstructBinaryTreefromInorderandPostorderTraversal {

	public class TreeNode {
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

	HashMap<Integer, Integer> map;
	int idx;

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		if (inorder.length == 0)
			return null;

		idx = postorder.length - 1;
		map = new HashMap<>();

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}

		return helper(inorder, postorder, 0, inorder.length - 1);

	}

	private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {

		// if(idx <0)
		// return null;

		if (start > end)
			return null;

		int rootval = postorder[idx];
		idx--;

		TreeNode root = new TreeNode(rootval);

		System.out.println(root.val);

		int rIdx = map.get(rootval);

//	         root.left= helper(inorder, postorder,start, rIdx -1);
//	         root.right= helper(inorder, postorder,rIdx+1, end);

		root.right = helper(inorder, postorder, rIdx + 1, end);
		root.left = helper(inorder, postorder, start, rIdx - 1);

		return root;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConstructBinaryTreefromInorderandPostorderTraversal objIn = new ConstructBinaryTreefromInorderandPostorderTraversal();

	}

}
