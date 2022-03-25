// Time Complexity : O(n); 
// Space Complexity : O(H);where H is height of the tree
class SumRootToLeafPath {	
	static class TreeNode {	
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
	
	public int sumNumbers(TreeNode root) {        
        return helper(root, 0);        
    }    
    private int helper(TreeNode root, int num){
        //base
        if(root==null) return 0;  
        if(root.left==null && root.right==null) return (num*10+root.val);
        
        //logic        
        return helper(root.left, num*10+root.val) + helper(root.right, num*10+root.val);
    }
	
	// Driver code to test above 
    public static void main(String args[]) {
    	SumRootToLeafPath ob = new SumRootToLeafPath();
    	TreeNode t= new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));	
    	//TreeNode t= new TreeNode(8, new TreeNode(4, new TreeNode(2), new TreeNode(6)), new TreeNode(12, new TreeNode(10), new TreeNode(14)));
		
		System.out.print("Sum of root to leaf paths in BST :"+ ob.sumNumbers(t));		
    } 
}