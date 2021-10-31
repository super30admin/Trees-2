// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashMap;

public class ConstructBST_post_in {
	 int p;
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        p=postorder.length-1;
	        HashMap<Integer,Integer> map=new HashMap<>();
	        for(int i=0;i<inorder.length;i++){
	            map.put(inorder[i],i);
	        }
	        return helper(postorder,0,postorder.length-1,map);
	    }
	    
	    public TreeNode helper(int[] postorder, int start,int end,HashMap<Integer,Integer> map){
	        if(start>end){
	            return null;
	        }
	        
	        TreeNode root=new TreeNode(postorder[p]);
	        int inorderIndex=map.get(root.val);
	        int count=end-inorderIndex;
	        p--;
	        root.right=helper(postorder,inorderIndex+1,end,map);
	        root.left=helper(postorder,start,inorderIndex-1,map);
	        
	        return root;
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
