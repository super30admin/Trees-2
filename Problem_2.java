// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

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
    Map<Integer, Integer> map = new HashMap<>();
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postIndex = n - 1;
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
		return buildUtil(inorder, postorder, 0, n - 1);
    }
    
    
    private TreeNode buildUtil(int in[], int post[], int inStrt,
				int inEnd)
	{
		if (inStrt > inEnd)
			return null;
		TreeNode node = new TreeNode(post[postIndex--]);

		if (inStrt == inEnd)
			return node;

		int iIndex = map.get(node.val);
		node.right = buildUtil(in, post, iIndex + 1, inEnd);
		node.left = buildUtil(in, post, inStrt, iIndex - 1);

		return node;
	}
}