// Time Complexity :O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   public TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> inorderIdxMap = new HashMap<>();	

        for (int i = 0; i < inorder.length; i++) {		// put all the values according to the index in the hashmap
            inorderIdxMap.put(inorder[i], i);
        }

        Stack<Integer> postorderStack = new Stack<>();		// all the values from post order array are pushed into stack
        for (int i = 0; i < postorder.length; i++) {
            postorderStack.push(postorder[i]);
        }

        return buildTree(postorderStack, 0, postorder.length - 1, inorderIdxMap);		// recursively call the buildTree function from the back, since we know that root can be 
    }																					// accessed from the last value in the postorder traversal

    public static TreeNode buildTree(Stack<Integer> postorderStack, int left, int right, Map<Integer, Integer> inorderIdxMap) {

        if (left > right || postorderStack.isEmpty()) {		// base case
            return null;
        }

        int root = postorderStack.pop();		// last element that is pushed will be the root of the tree
        TreeNode node = new TreeNode(root);		// create a node with the root element
        int inorderIdx = inorderIdxMap.get(root);	// get the index of the root from hashmap and traverse the tree recursively on left and right until we finish the binary tree
        node.right = buildTree(postorderStack, inorderIdx + 1, right, inorderIdxMap);
        node.left = buildTree(postorderStack, left, inorderIdx - 1, inorderIdxMap);

        return node;		// return the final node 
    }
}