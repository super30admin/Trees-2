//@ Time Complexity : O(N)
//@Space Complexity : O(H)
//Depth First Solution

package RootLeafSum_LC129;

public class RootLeafSum_LC129 {
	public static class TreeNode {
	     int val;
	     TreeNode left;
	    TreeNode right;
	     TreeNode(int x) 
	     { 
	    	 val = x; 
	      }
	     
	 }
	
	static TreeNode root; 

public int sumNumbers(TreeNode root) {
	        
	        return helper(root, 0);
	    }
	    
	    private int helper(TreeNode root,int val1)
	    {
	        if(root == null)
	        {
	            return 0;
	        }
	        
	        if(root.left==null && root.right==null)
	        {
	            return root.val+val1*10;
	        }
	        
	        return helper(root.left, root.val+val1*10) + helper(root.right, root.val+val1*10);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RootLeafSum_LC129 tree = new RootLeafSum_LC129(); 
        tree.root = new TreeNode(6); 
        tree.root.left = new TreeNode(3); 
        tree.root.right = new TreeNode(5); 
        tree.root.right.right = new TreeNode(4); 
        tree.root.left.left = new TreeNode(2); 
        tree.root.left.right = new TreeNode(5); 
        tree.root.left.right.right = new TreeNode(4); 
        tree.root.left.right.left = new TreeNode(7); 
           
        System.out.print("Sum of all paths is " +  
                                 tree.sumNumbers(RootLeafSum_LC129.root));  

	}

}
