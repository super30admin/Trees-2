/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 /*
Time Complexity: O(n^2)
Space Complexity: O(n)
Did the code run on leetcode? Yes
Approach: Take last value from the PostOrder array, which will always be the root for the tree(or subtree). Then, locate this index in inorder array and call the location as index. 
*Get the elements from the left of this index in inorder which form the left subtree and do the mirror for the right subtree and call the function recursively
*/
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
		if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) 
            return null;
        
		TreeNode root = new TreeNode(postorder[postorder.length-1]);//last index in postOrder is the main root
        
		if(postorder.length==1) 
            return root;
        
		int rootindex = -1;
        
		for(int i=0;i<inorder.length;i++){
            if(inorder[i]==root.val) {
                rootindex=i; break; 
            } 
        }
		int[] inordersubleft    = Arrays.copyOfRange(inorder, 0, rootindex);
		int[] inordersubright   = Arrays.copyOfRange(inorder, rootindex+1, inorder.length);
		int[] postordersubleft  = Arrays.copyOfRange(postorder, 0, rootindex);
		int[] postordersubright = Arrays.copyOfRange(postorder, rootindex, postorder.length-1);
        
		root.left  = buildTree(inordersubleft,postordersubleft);
		root.right = buildTree(inordersubright,postordersubright);
        
		return root;
	}
}