

//idea:  recrusive solution.
//postorder means  left right root and inorder means left root right .
//therefore last element in postorder is root of BT. WE will search this root in inorder to find its left and right element .
//so in inorder once root element is found then all  element to its left are left of root and all element to its right are right of root
//time complexity o(n) 
//space complexity is o(n)
////Did this code successfully run on Leetcode : yes
//Any problem you faced while coding this:no
public class AllSumRootToLeafNode {
	
	//class TreeNode
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int value) {
			val = value;
		}
	}

	  public static int sumNumbers(TreeNode root) {
	        if(root == null) return 0;
	        int result = helper(root,0);
	        return result;
	    }
	  
	  //helper function to calculate total sum of all combinations from root to leaf nodes
	    public static int helper(TreeNode root, int val){
	             if(root == null) return 0;
	             
	             //calculate sum 
	           val = 10 * val + root.val;
	           
	           //check to identify leaf node
	        if(root.left == null && root.right == null){
	            return val;
	        }
	        
	        //recursion
	        return helper(root.left, val) +helper(root.right, val);
	    }

	public static void main(String[] args) {
		TreeNode nums = new TreeNode(1);
		nums.left =new TreeNode(2);
		nums.right = new TreeNode(3);
		int sum = sumNumbers(nums);
		System.out.println("sum of all from root to leaf node is"+sum);
		
	}
}
