//Iterative Solution

// Time Complexity : O(N)
// Space Complexity : O(H). where H is height of tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
import java.util.Stack;

class TreeNode {
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

public class Sum_root_to_leaf_numbers_Iterative {
	class Pair {
		TreeNode node;
		int value;

		public Pair(TreeNode node, int value) {
			this.node = node;
			this.value = value;
		}

		public TreeNode getKey() {
			return this.node;
		}

		public int getValue() {
			return this.value;
		}
	}

	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Stack<Pair> st = new Stack<>();
		int curSum = 0;
		int result = 0;
		while (root != null || !st.isEmpty()) {
			while (root != null) {
				curSum = curSum * 10 + root.val;
				st.push(new Pair(root, curSum));
				root = root.left;
			}
			Pair p = st.pop();
			root = p.getKey();
			curSum = p.getValue();
			if (root.left == null && root.right == null) {
				result += curSum;
			}
			root = root.right;
		}
		return result;
	}
}
