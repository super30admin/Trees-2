// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes


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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
           
        }
        
        return helper(map, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
        
    }
    
    private TreeNode helper(Map<Integer, Integer> map, int[] postorder, int inLeft, int inRight, int poLeft, int poRight) {
        if (inLeft > inRight) {
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[poRight]);
        int inMid = map.get(root.val);
        
        root.left = helper(map, postorder, inLeft, inMid - 1, poLeft, poLeft + inMid - inLeft - 1);
        root.right = helper(map, postorder, inMid + 1, inRight, poRight - inRight + inMid, poRight - 1);
        return root;
    }
	
}