// TC: O(N) where we are traversing N elements of inorder/postorder array
// SC: O(N) for recursion stack

// We are considering the concept that last element in the postorder array will alwaya be root element. We search for the root element in inorder array.
// elements left to root in inorder array belong to left subtree and element to the right of array should belong to right subtree. We repeat this process
// until we have traversed thw whole array.

import java.util.*;

public class ConstructBTIP {

	public TreeNode constructBT(int[] inorder, int[] postorder) {
		
		if(postorder==null || postorder.length==0)
			return null;
		HashMap<Integer, Integer> inorderMap = new HashMap<>();
		for(int i=0;i<inorder.length;i++)
			inorderMap.put(inorder[i],i);
		return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1, inorderMap);
	}
	
	public TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> map) {
		
		if(inStart>inEnd || postStart> postEnd)
			return null;
		
		TreeNode root = new TreeNode(postorder[postEnd]);
		int ri = map.get(postorder[postEnd]);
		System.out.println(ri+ " "+postStart + " "+ postEnd);
		root.left = buildTree(inorder, inStart, ri-1, postorder, postStart, postStart+ri-inStart-1, map);
		root.right = buildTree(inorder, ri+1, inEnd, postorder, postStart+ri-inStart, postEnd-1, map);
		
		return root;
	}
	
	public static void main(String[] args) {
		ConstructBTIP csbt = new ConstructBTIP();
		int[] inorder = {9,3,15,20,7};
		int[] postorder = {9,15,7,20,3};
		TreeNode root = csbt.constructBT(inorder, postorder);
		System.out.println(root.val);
		System.out.println(root.left.val+" "+root.right.val+" "+ root.right.left.val+" "+root.right.right.val);
	}
}
