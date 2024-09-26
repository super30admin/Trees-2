// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


/**
 * https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.
 *
 */
public class SumRootToLeaf {
	public int sumNumbers(TreeNode root) {

		if(root == null) return 0;

		return helper(root, 0);
	}

	//recursive solution
	private int helper(TreeNode root, int prev) {

		//base
		if(root == null) return 0;

		if(root.left == null && root.right == null) return (root.val + (prev * 10));

		// logic
		return helper(root.left, root.val + (prev * 10)) +
				helper(root.right, root.val + (prev * 10));
	}
	
	/**
	 * Iterative solution
	 */
	 class Pair{
	        int currSum;
	        TreeNode node;
	        
	        public Pair(int sum, TreeNode node) {
	            this.currSum = sum;
	            this.node = node;
	        }
	    }
	    public int sumNumbers(TreeNode root) {
	        
	        Stack<Pair> st = new Stack<>();
	        int currSum = 0, res = 0;
	        while(root != null || !st.isEmpty()) {
	            while(root != null) {
	                currSum = currSum*10 + root.val;
	                Pair pr = new Pair(currSum, root);
	                st.push(pr);
	                root = root.left;
	            }
	            
	            Pair pr = st.pop();
	            
	            if(pr.node.left == null && pr.node.right == null){
	                res+= pr.currSum;
	            }
	            
	            currSum = pr.currSum;
	            root = pr.node.right;
	        }
	        
	        return res;
	    }
}
