// Time Complexity : O(N)
// Space Complexity : O(H) // H is the height of the tree 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/**
 * 1. Write code for pre traversal of the binary tree as it produces output in incremental order.
 * 2. At each root calculate the sum.
 * 3. when you reach leaf node means node which has left and right node as null add sum to result.
 */

public class SumRootToLeaf {
	int result = 0;

	public int sumNumbers(TreeNode root) {
		cal(root, 0);
		return result;
	}

	private void cal(TreeNode root, int sum) {
		if (root == null) {
			return;
		}

		sum = sum * 10 + root.val;

		cal(root.left, sum);
		
		if(root.left==null && root.right==null) {
			result =result+sum;
		}
		
		cal(root.right, sum);

	}

	public static void main(String[] args) {
		TreeNode root= new TreeNode(4);
		
		root.left= new TreeNode(9);
		root.right= new TreeNode(0);
		root.left.left=new TreeNode(5);
		root.left.right=new TreeNode(1);
		
		
		System.out.println(new SumRootToLeaf().sumNumbers(root));
	}
}

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
