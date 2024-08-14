// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    private int postorderIndex;
    private HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        
        // Build a map to find the index of any value in inorder array
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        // Recursively build the tree
        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
        // Base case
        if (inorderStart > inorderEnd) {
            return null;
        }
        
        // The last element in postorder is the root
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);
        
        // Find the index of the root in inorder to determine the boundary of left and right subtrees
        int rootIndexInInorder = inorderIndexMap.get(rootValue);
        
        // Build right subtree first since postorder is processed from end
        root.right = buildTreeHelper(inorder, postorder, rootIndexInInorder + 1, inorderEnd);
        root.left = buildTreeHelper(inorder, postorder, inorderStart, rootIndexInInorder - 1);
        
        return root;
    }
}
