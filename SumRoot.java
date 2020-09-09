import java.util.Stack;

public class SumRoot {

	class PairValue {
		int key;
		TreeNode root;

		public PairValue(TreeNode root, int val) {
			// TODO Auto-generated constructor stub
			this.root = root;
			this.key = val;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public TreeNode getNode() {
			return root;
		}

		public void setNode(TreeNode root) {
			this.root = root;
		}

	}

	public int sumNumbers(TreeNode root) {
		int result = 0;
		if (null == root) { // base/edge condition
			return 0;
		}
		int currResult = 0;
		Stack<PairValue> st = new Stack<PairValue>();
		while (root != null || !st.isEmpty()) {

			while (root != null) {
				currResult = currResult * 10 + root.val;
				st.push(new PairValue(root, currResult));
				root = root.left;
			}
			PairValue pv = st.pop();
			root = pv.getNode();
			currResult = pv.getKey();
			if (root.left == null || root.right == null)
				result += currResult;

			root = root.right;

		}

		return result;

	}

	public static void main(String[] args) {

		TreeNode left = new TreeNode(2, null, null);
		TreeNode right = new TreeNode(3, null, null);
		TreeNode root = new TreeNode(1, left, right);
		
		SumRoot sumroot = new SumRoot();
		System.out.println(sumroot.sumNumbers(root));

	}

}
