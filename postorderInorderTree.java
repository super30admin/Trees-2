// Time Complexity : O(N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.


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
    int postIdx;
    HashMap<Integer,Integer> result;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = inorder.length - 1;
        result = new HashMap<>();
        for(int i =0; i<inorder.length; i++)
        {
            result.put(inorder[i], i);
        }
        return helper(inorder,postorder,0,inorder.length -1);
    }
    public TreeNode helper(int[] inorder, int[] postorder, int start, int end)
    {
        //base
        if(start > end) return null;
        //logic
        TreeNode root = new TreeNode(postorder[postIdx]);
        int inorderIdx = result.get(root.val);
        postIdx--;
        root.right= helper(inorder,postorder,inorderIdx+1,end);
        root.left= helper(inorder,postorder,start,inorderIdx-1);
        return root;
    }
}