import java.util.Stack;

public class RootToLeafSum {

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

	class Pair {
		TreeNode node;
		int val;

		Pair(TreeNode node, int val) {
			this.node = node;
			this.val = val;
		}

		public TreeNode getNode() {
			return node;
		}

		public int getVal() {
			return val;
		}
	}

	// Iterative - Tc - O(n) , Sc - O(n)
	public int sumNumbers(TreeNode root) {

		if (root == null)
			return 0;
		Stack<Pair> st = new Stack<>();
		int currSum = 0;
		int result = 0;

		while (root != null || !st.isEmpty()) {
			// push left root until we hit null
			while (root != null) {
				// number formation
				currSum = currSum * 10 + root.val;
				// push current sum and root to stack
				st.push(new Pair(root, currSum));
				root = root.left;
			}
			Pair p = st.pop();
			root = p.getNode();
			currSum = p.getVal();
			// if leaf node add it to the result
			if (root.left == null && root.right == null)
				result += currSum;

			root = root.right;
		}
		return result;
	}

}

// recursion - tc - O(n) sc - O(1), under the hood o(n)
//class Solution {
//    int result;
//    public int sumNumbers(TreeNode root) {
//        
//        if(root == null) return 0;
//        return helper(root,0);
//        
//    }
//    
//    private int helper(TreeNode root, int currSum) {
//        //base
//        if(root == null) return 0;
//        //logic
//        currSum = currSum*10 + root.val;
//        helper(root.left,currSum);
//        //if leaf node add it to the result
//        if(root.left == null && root.right == null)
//                result += currSum;
//        helper(root.right,currSum);
//        return result;
//    }
//    
//}
