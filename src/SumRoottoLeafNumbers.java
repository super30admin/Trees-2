/*
 * The complexity of the algorithm is O(n) where n is no of elements.

 */

public class SumRoottoLeafNumbers {

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

	int result = 0;

	public int sumNumbers(TreeNode root) {

		helper(root, 0);

		return result;

	}

	private void helper(TreeNode root, int currSum) {

		if (root == null)
			return;

		currSum = currSum * 10 + root.val;

		helper(root.left, currSum);

		if (root.left == null && root.right == null)
			result = result + currSum;

		helper(root.right, currSum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SumRoottoLeafNumbers objIn = new SumRoottoLeafNumbers();

	}

}
