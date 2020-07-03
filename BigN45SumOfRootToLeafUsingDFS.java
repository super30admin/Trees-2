// Time complexity is O(N) as we are visiting each and every node
// space complexity is O(H) that is of recursion stack which is the height of the tree.
// This solution is submitted on leetcode

public class BigN45SumOfRootToLeafUsingDFS {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		// edge
		if (root == null)
			return 0;
		return helper(root, 0);
	}

	private int helper(TreeNode root,int earlyValue) {
		// base case
		if(root == null)
			return 0; 
		if(root.left == null && root.right ==null)
			return earlyValue*10 + root.val;
		//logic
		int left = helper(root.left,earlyValue*10+root.val);
		int right = helper(root.right,earlyValue*10+root.val);
		return left+right;
	}
}
