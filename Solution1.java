// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
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
    int postidx;
    HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postidx = postorder.length-1;
        map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, inorder.length -1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int left, int right)
    {
        if (left>right) return null;
        int rootval = postorder[postidx];
        TreeNode root = new TreeNode(rootval);
        postidx--;
        int idx = map.get(rootval);
        root.right = helper(inorder, postorder, idx+1, right);
        root.left = helper(inorder, postorder, left, idx-1);
        
        return root;
    }
}