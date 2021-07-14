// Time Complexity : O(n)
// Space Complexity : O(h), h -> Height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

public class SumRootToLeaves {
	int sum = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}

		helper(root, 0);
		return sum;
	}

	private void helper(TreeNode root, int num) {
		if (root == null) {
			return;
		}

		num = num * 10 + root.val;
		if (root.left == null && root.right == null) {
			sum += num;
		}

		helper(root.left, num);
		helper(root.right, num);
	}

	public static void main(String[] args) {
		SumRootToLeaves obj = new SumRootToLeaves();

		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);

		System.out.println("Sum = " + obj.sumNumbers(root));
	}

}
