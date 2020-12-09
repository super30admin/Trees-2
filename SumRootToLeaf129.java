package dec8th2020;

public class SumRootToLeaf129 {
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

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root, 0, 0);

	}

	private int helper(TreeNode root, int currSum, int result) {
		if (root == null)
			return 0;
		if (root.left == null & root.right == null) {
			result = result + currSum * 10 + root.val;
			return result;
		}
		return helper(root.left, currSum * 10 + root.val, result) + helper(root.right, currSum * 10 + root.val, result);

	}

}
