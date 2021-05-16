// Space complexity - O(n)
// Space complexity - O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
public TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
	
	if (inorder == null || postorder == null || inorder.length != postorder.length)
	{
		return null;
		
	}
	HashMap<Integer, Integer> map1 = new HashMap<Integer,Integer>();
	
	for (int i=0;i<inorder.length;++i) 
	{
		map1.put(inorder[i], i);
	}
	return helper(inorder, 0, inorder.length-1, postorder, 0, 
                          postorder.length-1,map1);
}

private TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, 
                                 HashMap<Integer,Integer> map1){
	
	if (ps>pe || is>ie) {
		return null;
	}
	
	TreeNode root = new TreeNode(postorder[pe]);
	
	int ri = map1.get(postorder[pe]);
	
	TreeNode leftchild = helper(inorder, is, ri-1, postorder, ps, ps+ri-is-1, map1);
	TreeNode rightchild = helper(inorder,ri+1, ie, postorder, ps+ri-is, pe-1, map1);
	
	root.left = leftchild;
	root.right = rightchild;
	
	return root;
}
}