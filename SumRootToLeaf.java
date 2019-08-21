package binaryTrees;

/**
 * Time: O(n)
 * Space: O(1) except stack space for recursion
 * Leetcode accepted: yes
 * Problems faced: No
 */
public class SumRootToLeaf {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(sumNumbers(root));
	}
	
	public static int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

	private static int helper(TreeNode root, int sum) {
		//Base case
		if(root == null) return 0;
		
		//At every step, multiply the current sum by 10 and add it to current node value
		if(root.left == null && root.right == null) {
			return sum*10 + root.val;
		}
		return helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val);
	}

}
