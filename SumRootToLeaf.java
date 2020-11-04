import java.util.Stack;

public class SumRootToLeaf {
	int result = 0;

	public int sumNumbers(TreeNode root) {
		int currSum = 0;

		if (root == null)
			return -1;

		Stack<Pair> st = new Stack<>();
		while (root != null || !st.isEmpty()) {
			while (root != null) {
				currSum = currSum * 10 + root.val;
				st.push(new Pair(root, currSum));
				root = root.left;
			}
			Pair p = st.pop();
			root = p.keyNode;
			if(root.left==null && root.right ==null)
				result += p.data;
			root = root.right;
		}

		return result;
	}
}
