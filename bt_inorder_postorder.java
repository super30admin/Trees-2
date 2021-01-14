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
    HashMap<Integer, Integer> map = new HashMap<>();
    int index;  //post order index
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null)
            return null;
        for(int i=0; i<inorder.length; i++)
            map.put(inorder[i], i);
        index = postorder.length - 1;
        return helper(postorder, 0, inorder.length -1);
    }
    private TreeNode helper(int[] postorder, int start, int end){
        if(start > end)
            return null;
        
        int rootValue = postorder[index]; index--;
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        root.right = helper(postorder, rootIndex+1, end);
        root.left = helper(postorder, start, rootIndex-1);
        return root;
            
    }
}