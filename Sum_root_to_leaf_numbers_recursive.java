// Time Complexity : O(N)
// Space Complexity : O(H), where H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class TreeNode1 {
	int val;
	TreeNode1 left;
	TreeNode1 right;

	TreeNode1() {
	}

	TreeNode1(int val) {
		this.val = val;
	}

	TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

public class Sum_root_to_leaf_numbers_recursive {
	public int sumNumbers(TreeNode1 root) {
		return helper(root, 0);
	}

	public int helper(TreeNode1 root, int curSum) {
		// base case
		if (root == null) {
			return 0;
		}
		// logic
		if (root.left == null && root.right == null) {
			return curSum * 10 + root.val;
		}
		int left = helper(root.left, curSum * 10 + root.val);
		int right = helper(root.right, curSum * 10 + root.val);
		return left + right;
	}
}
