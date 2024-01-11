// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NO


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
    int index;
    HashMap<Integer, Integer> hmap;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.index = postorder.length - 1;
        this.hmap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            hmap.put(inorder[i],i);
        }
       return helper(postorder, 0 , inorder.length - 1);      
    }

    private TreeNode helper(int[] postorder, int start, int end){
        if(index < 0 || start > end) return null;
        int rootval = postorder[index];
        TreeNode root = new TreeNode(rootval);
        index--;
        int rootIndex = hmap.get(rootval);

       
        root.right = helper(postorder, rootIndex + 1, end);
        root.left = helper(postorder,start,rootIndex - 1);

        return root;
    }
}