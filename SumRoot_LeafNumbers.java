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
		helper(root, 0);	// calling recursive inorder method with sum 0
		return result;
	}
	private static void helper(TreeNode root, int currentSum){
		if(root == null)    // base case, when we reach a point where there is one child and other is null
			return;

		currentSum = currentSum * 10 + root.val;

		if(root.left == null && root.right == null)
			result += currentSum;	// calculate sum for the leaf and return sum

		helper(root.left, currentSum);	 // calling for left subtree with sum
		helper(root.right, currentSum);	// calling for right subtree with sum
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

			Stack<Pair> stack = new Stack<>();	// creating stack for pairs
			int currentSum = 0;
			int result = 0;
			while(root != null || !stack.isEmpty()){		//execute till the node becomes null and stack is empty
				while(root != null){	// till we reach null
					currentSum = currentSum * 10 + root.val;	// finding sum for the root
					stack.push(new Pair(root, currentSum));	// adding root and sum to stack
					root = root.left; // traversing left
				}
				
				Pair pairPopped = stack.pop();	//on popping we get a pair
				root = pairPopped.getKey();
				currentSum = pairPopped.getValue();	// getting the sum corresponding to the root we popped
				
				if(root.left == null && root.right == null){	//checking whether its a leaf node
					result += currentSum;	// if leaf we add the popped sum to result
				}
				root = root.right;	// traverse right
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

