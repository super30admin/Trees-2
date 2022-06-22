/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        //null check
		if (postorder.length == 0 || inorder.length == 0) {
			return null;
		}
		//find the root in Order using post-order
		int rootValue= postorder[postorder.length-1];
        
		
		HashMap<Integer, Integer> inOrderMap = new HashMap<Integer,Integer>();
		
		for (int i=0; i<inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		TreeNode rootNode = new TreeNode(rootValue);
        int rootIndex ;
        if (null != inOrderMap.get(rootValue)) {
            rootIndex = inOrderMap.get(rootValue);

            
            int[] inOrderLeft = Arrays.copyOfRange(inorder, 0, rootIndex);
            
            int[] inOrderRight = Arrays.copyOfRange(inorder,rootIndex+1, inorder.length);
            
            int[] postOrderLeft = Arrays.copyOfRange(postorder, 0, inOrderLeft.length);
            
            int[] postOrderRight = Arrays.copyOfRange(postorder,inOrderLeft.length, postorder.length-1);
            
            System.out.println(rootNode.val);
            rootNode.left = buildTree(inOrderLeft,postOrderLeft);
            rootNode.right = buildTree(inOrderRight,postOrderRight);

        }
		  
		
	
		return rootNode;
    }
}