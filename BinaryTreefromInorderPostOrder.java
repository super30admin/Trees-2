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
    
    
    private TreeNode buildUtil(int in[], int post[], int instart, int inend)
	{
		if (instart > inend)
			return null;

		TreeNode node = new TreeNode(post[postIndex--]);

		if (instart == inend)
			return node;

		int inIndex = map.get(node.val);

		node.right = buildUtil(in, post, inIndex + 1, inend);
		node.left = buildUtil(in, post, instart, inIndex - 1);

		return node;
	}
}

//Time complexity : O(N) where N is the number of nodes 
//Space complexity : O(N+h) where h is height of recursive tree
