// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


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
    
    HashMap<Integer, Integer> map;
    int idx;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        if(inorder == null || inorder.length == 0) {
            return null;
        }
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        idx = postorder.length - 1;
        return helper(inorder, postorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int start, int end) {
        if(start > end) {
            return null;
        }
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx--;
        int rootIdx = map.get(rootVal);
        root.right = helper(inorder, postorder, rootIdx + 1, end);
        root.left = helper(inorder, postorder, start, rootIdx - 1);
        return root;
    }
}