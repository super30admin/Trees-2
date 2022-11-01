// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None.


// Your code here along with comments explaining your approach
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
	public int sumNumbers(TreeNode root) {
		 return helper(root, 0);
	}
	
	private int helper(TreeNode root, int sum) {
		 if (root == null) return 0;
		 
		 if (root.left == null && root.right == null) {
			  sum = sum*10 + root.val;
			  return sum;
		 }
		 
		 return helper(root.left, sum*10+root.val) + helper(root.right, sum*10+root.val);
	}
}