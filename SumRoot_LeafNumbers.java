//Time Complexity: O(n),  n is the number of nodes in the tree
//Space Complexity: O(h), height of the tree
//Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this : no


import java.util.Stack;

//Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode() {}
	TreeNode(int val) { this.val = val; }
	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}

/********************************Approach 1: Recursive*****************************************************/
/* Current sum is calculated as currentSum * 10 + root.val
 * Traversing from root to the leaf of one branch of the tree will be added to the result and once complete tree is traversed, we return result*/

public class SumRoot_LeafNumbers {
	static int result;
	public static int sumNumbers(TreeNode root) {
		if(root == null)
			return 0;
		helper(root, 0);
		return result;
	}
	private static void helper(TreeNode root, int currentSum){
		if(root == null)    // base case
			return;

		currentSum = currentSum * 10 + root.val;

		if(root.left == null && root.right == null)
			result += currentSum;

		helper(root.left, currentSum);
		helper(root.right, currentSum);
	}


	/***********************************Approach 2: Iterative**************************************************/
	/* Stack is used to store pair(node, value). 
	 * Push the value of the current node and current sum.
	 * Current sum is calculated as currentSum * 10 + root.val
	 * Traversing from root to the leaf of one branch of the tree will be added to the result and once complete tree is traversed, we return result*/

	class  Pair{
		TreeNode node;
		int value;
		public Pair(TreeNode node, int value){
			this.node = node;
			this.value = value;
		}
		public TreeNode getKey(){
			return this.node;
		}
		public int getValue(){
			return this.value;
		}
	}

	public class SumRoot_LeafNumbers {
		public static int sumNumbers(TreeNode root) {
			if(root == null)    // base case
				return 0;

			Stack<Pair> stack = new Stack<>();
			int currentSum = 0;
			int result = 0;
			while(root != null || !stack.isEmpty()){
				while(root != null){
					currentSum = currentSum * 10 + root.val;
					stack.push(new Pair(root, currentSum));
					root = root.left;
				}
				Pair pairPopped = stack.pop();
				root = pairPopped.getKey();
				currentSum = pairPopped.getValue();
				if(root.left == null && root.right == null){
					result += currentSum;
				}
				root = root.right;
			}
			return result;
		}


		public static void main(String[] args) {
			TreeNode tree = new TreeNode(); 
			tree = new TreeNode(1); 
			tree.left = new TreeNode(2); 
			tree.right = new TreeNode(3);  

			System.out.println(sumNumbers(tree));
		}
	}

