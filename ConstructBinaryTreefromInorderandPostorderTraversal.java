package s30Coding;
import java.util.*;

//Time Complexity :- O(n)

//Space Complexity :- O(n)

//LeetCode :- Yes

public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right; TreeNode() {}
		TreeNode(int val) { this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
			}
		}
	
	
	 HashMap<Integer, Integer> map;
	    int index;
	    public TreeNode buildTree(int[] inorder, int[] postorder) {
	        if(postorder == null || postorder.length == 0){
	            return null;
	        }
	        map = new HashMap<>();
	        index = postorder.length - 1;
	        for(int i = 0; i < inorder.length; i++){
	            map.put(inorder[i],i);
	        }
	        
	        return helper(postorder, 0, postorder.length - 1);
	    }
	    
	    private TreeNode helper(int[] postorder, int start, int end){
	        if(start > end){
	            return null;
	        }
	        
	        int inIdx = postorder[index];
	        TreeNode root = new TreeNode(inIdx);
	        
	        int tempIndex = map.get(inIdx);
	        index--;
	        root.right = helper(postorder, tempIndex + 1, end);
	        root.left = helper(postorder, start, tempIndex - 1);
	        
	        
	        return root;
	    }
}
