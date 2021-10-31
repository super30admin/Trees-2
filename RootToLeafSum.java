// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class RootToLeafSum {
	 int sum=0;
	    public int sumNumbers(TreeNode root) {
	        helper(root,0);
	        return sum;
	    }
	    
	    public void helper(TreeNode root,int number){
	        if(root==null){
	            return;
	        }
	        
	        if(root.left==null && root.right==null){
	            number=number*10+root.val;
	            sum+=number;
	            return;
	        }
	        
	        number=number*10+root.val;
	        helper(root.left,number);
	        helper(root.right,number);
	        return;
	    }
	    
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
}
