// Time Complexity : O(n)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :
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
    HashMap<Integer, Integer> theMap;
    int rootIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // base case
        if ( postorder == null || postorder.length == 0 || inorder.length == 0) return null;
        theMap = new HashMap<>();
        rootIdx = postorder.length - 1;
        //populate inorder value -> index map
        for (int i=0; i<inorder.length; i++) {
            theMap.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] postorder, int[] inorder, int start, int end) {
        // base
        if (start > end) {
            return null;
        }
        // find the root index and initialize tree node
        int rootValue = postorder[rootIdx];
        rootIdx--;
        TreeNode root = new TreeNode(rootValue);
        int inIdx = theMap.get(rootValue);
        root.right = helper(postorder, inorder, inIdx + 1, end);
        root.left = helper(postorder, inorder, start, inIdx-1);
        return root;
    }
}