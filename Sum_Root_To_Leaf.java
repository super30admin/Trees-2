
//Approach:1. Here am traversing through each node using dfs traversal and meanwhile checking if I have reached the leaf node, if so I will add the the path sum to global sum.
//2. Doing this recursively to travel all the paths and adding the path value to sum. 
public class Sum_Root_To_Leaf {
	 int sum;
	    public int sumNumbers(TreeNode root) {
	        sum = 0;
	        if(root == null)
	            return sum;
	        helper(root, 0);
	        return sum;
	    }
	    public void helper(TreeNode root, int prevSum)
	    {
	        if(root == null)return;
	        
	        int currSum = prevSum *10 + root.val;
	        if(root.left == null && root.right == null)
	        {
	            sum+=currSum;
	            return;
	        }
	        helper(root.left, currSum);
	        helper(root.right, currSum);
	    }
}
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
//Time Complexity : O(n) where n is the number of nodes
//Space Complexity : O(h) where h is the height of the tree. Since the recursive stack might hold elements equal to the height of the tree at worst case.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :
