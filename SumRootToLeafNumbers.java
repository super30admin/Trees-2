package trees2;

import java.util.Stack;

public class SumRootToLeafNumbers {
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
	
	//Iterative
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	class Pair {
        TreeNode root;
        int currSum;
        
        Pair(TreeNode root, int currSum) {
            this.root = root;
            this.currSum = currSum;
        }
        
        public TreeNode getNode() {
            return this.root;
        }
        
        public int getValue() {
            return this.currSum;
        }
    }
	
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        Stack<Pair> stack = new Stack<>();
        int currSum = 0;
        
        while(root != null || !stack.isEmpty()) {
            while(root != null) {
                currSum = currSum * 10 + root.val;
                Pair pair = new Pair(root, currSum);
                stack.push(pair);
                root = root.left;
            }
            
            Pair pair = stack.pop();
            root = pair.getNode();
            currSum = pair.getValue();
            if(root.left == null && root.right == null)
                sum += currSum;
            
            root = root.right;
        }
        
        return sum;
    }
	
	// Recursion
	//Time Complexity : O(n), where n is the height of tree
	//Space Complexity : O(n), Implicit stack for recursion
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	int sum = 0;
    public int sumNumbers1(TreeNode root) {
        helper(root, 0);
        return sum;
    }
    
    private void helper(TreeNode root, int currSum) {
        // base
        if(root == null)
            return;
        
        // logic
        if(root.left == null && root.right == null)
            sum += currSum * 10 + root.val;
        
        helper(root.left, currSum * 10 + root.val);
        helper(root.right, currSum * 10 + root.val);
    }
}
