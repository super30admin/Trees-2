import java.util.Stack;
//Problem 45
public class SumRoot {

	class PairValue {
		int key;
		TreeNode node;

		public PairValue(TreeNode node, int val) {
			// TODO Auto-generated constructor stub
			this.node = node;
			this.key = val;
		}

		public int getKey() {
			return key;
		}

		public TreeNode getNode() {
			return node;
		}

	}

	public int sumNumbers(TreeNode root) {
		int result = 0;
		if (null == root) { // base/edge condition
			return 0;
		}

		Stack<PairValue> st = new Stack<PairValue>();
		int currResult = 0;
		while (root != null || !st.isEmpty()) {

			while (root != null) {
				currResult = currResult * 10 + root.val;
				st.push(new PairValue(root, currResult));
				root = root.left;
			}
			PairValue pv = st.pop();
			root = pv.getNode();
			currResult = pv.getKey();
			if (root.left == null && root.right == null)
				result += currResult;

			root = root.right;

		}

		return result;

	}

	private int sumNumberRecur(TreeNode root) {

		return helper(root, 0);
	}

	private int helper(TreeNode root, int currVal) {
		// TODO Auto-generated method stub
		// base
		if (null == root) {
			return 0;
		}

		// logic
		if (root.left == null && root.right == null)
			return currVal * 10 + root.val;
		return helper(root.left, currVal * 10 + root.val) + helper(root.right, currVal * 10 + root.val);
	}

	public static void main(String[] args) {

		TreeNode left = new TreeNode(0, null, null);
		TreeNode right = new TreeNode(3, null, null);
		TreeNode root = new TreeNode(1, left, right);

		SumRoot sumroot = new SumRoot();
		System.out.println(sumroot.sumNumbers(root));
		System.out.println("Using recursion"+sumroot.sumNumberRecur(root));

	}

}
