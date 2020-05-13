package s30Coding;

//Time Complexity :- O(n) where n is the number of nodes in the tree

//Space Complexity :- O(h) where h is the height of the tree.

//LeetCode :- Yes


public class SumRoottoLeafNumbers {
	 public class TreeNode {
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
	 
	 
	  int result = 0;
	    public int sumNumbers(TreeNode root) {
	        helper(root,0);
	        return result;
	    }
	    private void helper(TreeNode root, int sum){
	        if(root == null) return;
	        sum =sum*10 + root.val; 
	        if(root.left == null && root.right == null){
	            result += sum;
	        }
	        helper(root.left,sum);
	        helper(root.right,sum);
	        
	    }
}
