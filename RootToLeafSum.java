// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Start from the root, check if it is null, if not,
 * add the root val to the sum by multiplying sum by 10 + root.val
 * then check if the root is the child. If so return the sum. If not,
 * process for left and right children and add those two sums and return
 * the final sum.
 *
 */
class Solution {
	public int sumNumbers(TreeNode root) {
		return helper(root, 0);
	}

	public int helper(TreeNode root, int sum) {
		if (root == null)
			return 0;
		sum = sum * 10 + root.val;
		if (root.left == null && root.right == null) {
			return sum;
		}
		return helper(root.left, sum) + helper(root.right, sum);
	}
}