package Q_129_Sum_Root_to_Leaf_Numbers;
//Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
//
//An example is the root-to-leaf path 1->2->3 which represents the number 123.
//
//Find the total sum of all root-to-leaf numbers.
//
//Note: A leaf is a node with no children.
//
//Example:
//
//Input: [1,2,3]
//    1
//   / \
//  2   3
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.
//Example 2:
//
//Input: [4,9,0,5,1]
//    4
//   / \
//  9   0
// / \
//5   1
//Output: 1026
//Explanation:
//The root-to-leaf path 4->9->5 represents the number 495.
//The root-to-leaf path 4->9->1 represents the number 491.
//The root-to-leaf path 4->0 represents the number 40.
//Therefore, sum = 495 + 491 + 40 = 1026.

//Time Complexity  : O(n)  
//Space Complexity : O(1)

public class Solution {

	
	public static class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	 public static int sumNumbers(TreeNode root) {
		 return helper(root, 0);
	    }
	 
	
	 public static int helper(TreeNode node, int currSum) {
		 
		 if(node == null) {
			 return 0;
		 }
		 if(node.left == null && node.right ==null) {
			 return 10*currSum + node.val;
		 }
		 return helper(node.left, 10*currSum + node.val) + helper(node.right, 10*currSum + node.val);
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		
		Solution s = new Solution();
		System.out.println(s.sumNumbers(root));
		

	}

}
