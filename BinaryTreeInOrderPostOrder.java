/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//Time Complexity: O(n)
//Space Complexity: O(n)

// A hashmap is used to get the indexes .
// Pointers are used to avoid passing copies.
// This makes the algorithm more efficient.

class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
        	map.put(inorder[i], i);
        }

        return buildTree(inorder, 0, postorder, 0, inorder.length, map);
    }

    private TreeNode buildTree(int[] inorder, int i, int[] postorder, int p, int size, HashMap<Integer, Integer> map) {
    	if(size == 0) {
    		return null;
    	}

    	if(size == 1) {
    		return new TreeNode(postorder[p]);
    	}

    	int rootValue = postorder[p + size -1];
    	int rootIndex = map.get(rootValue);
    	TreeNode root = new TreeNode(rootValue);

    	int leftSize = rootIndex - 1 - i + 1;
    	int rightSize = size - (leftSize + 1);

    	root.left = buildTree(inorder, i, postorder, p, leftSize, map);
    	root.right = buildTree(inorder, rootIndex + 1, postorder, p + leftSize, rightSize, map);

    	return root;
    }
}