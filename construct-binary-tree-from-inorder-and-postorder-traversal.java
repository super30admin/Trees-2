// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    HashMap<Integer, Integer> map;
    int postIdx = 0; // postorder 
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // TC = O(N), SC = O(N) + O(H) = O(N)
        // null
        if(inorder.length == 0 || postorder.length == 0) return null;
        postIdx = postorder.length - 1; // postorder 
        map = new HashMap<>();
        // record index of all inorder elements(TreeNodes)
        for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        // use postorder to find root & build right & left subtree recursively
        return helper(postorder, 0, postorder.length - 1);
    }
    private TreeNode helper(int[] postorder, int start, int end) {
        // base
        if(start > end) return null;
        // logic
        int rootVal = postorder[postIdx--];
        TreeNode root = new TreeNode(rootVal);
        int rootIdx = map.get(rootVal);
        // important to build right tree first then left, else runtime error
        root.right = helper(postorder, rootIdx + 1, end);
        root.left = helper(postorder, start, rootIdx - 1);
        return root;
    }
}