// Time Complexity : 0(n)
// Space Complexity : O(n)
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
    HashMap<Integer, Integer>  map;
    int idx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.idx = postorder.length-1;
        this.map = new HashMap<>();

        for(int i=0;i<inorder.length ; i++)
        {
            map.put(inorder[i], i);
        }
        return helper(postorder, 0, inorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int start, int end)
    {
        if(start>end)
        {
            return null;
        }

        int rootVal = postorder[idx];
        idx--;
        int rootIdx = map.get(rootVal);
        
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(postorder, rootIdx+1, end);
        root.left = helper(postorder,start, rootIdx-1);
        


        return root;
    } 
    
}