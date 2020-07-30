import java.util.HashMap;

public class Construct_Binary_Tree_From_Inorder_Preorder {
	//Approach: I use hashmap to store the indices of the nodes. Then I iterate through the inorder array, thereby getting the root from preorder traversal. 
	//2. Divide the left and root children index based on the root index and recursively construct the tree. 
	 HashMap<Integer, Integer> map;
	    int index;
	    public TreeNode buildTree(int[] preorder, int[] inorder) {
	        map = new HashMap<>(); index = 0;
	        for(int i=0;i<inorder.length;i++)
	        {
	            map.put(inorder[i], i);
	        }
	        return helper(preorder, inorder, 0, inorder.length-1);
	    }
	    private TreeNode helper(int[] preorder, int[] inorder, int start, int end)
	    {
	        if(start > end || index > inorder.length-1) return null;
	        int idx = map.get(preorder[index]);
	        TreeNode root = new TreeNode (inorder[idx]);
	        index++;
	        
	        root.left = helper(preorder, inorder, start, idx-1);
	        root.right = helper(preorder, inorder, idx+1, end);
	        return root;
	    }
}
//Time Complexity : O(n) where n is length of the inorder array
//Space Complexity : O(h) where h is the height of the tree. Since the recursive stack might hold elements equal to the height of the tree at worst case.
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this :