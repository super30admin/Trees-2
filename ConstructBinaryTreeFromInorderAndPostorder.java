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
    // Time Complexity : O(n)
    // Space Complexity : O(n)
    // Did this code successfully run on Leetcode : Yes
    // Any problem you faced while coding this : No
    int postOrderIdx;
    HashMap<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        postOrderIdx = len-1;
        for(int i = 0; i < len; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(postorder, 0, len-1);
    }

    public TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        if(left > right) return null;
        int rootVal = postorder[postOrderIdx--];
        TreeNode root = new TreeNode(rootVal);
        int idx = map.get(rootVal);

        root.right = buildTreeHelper(postorder, idx+1, right);
        root.left = buildTreeHelper(postorder, left, idx-1);

        return root;
    }
}