// Time Complexity :O(N)+O(1)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// Your Approach: Using recurssion method to call the function at every node

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
    int post_index;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
       this.inorder = inorder;
       this.postorder = postorder;
        this.post_index = postorder.length-1;
        int idx = 0;
        for(Integer val: inorder){
            hmap.put(val, idx++);
        }
        return bstNode(0, inorder.length-1);
    }
    
    public TreeNode bstNode(int left, int right){
        if(left > right)
            return null;
        int root_val = postorder[post_index--];
        TreeNode root = new TreeNode(root_val);
        
        int idx = hmap.get(root_val);
        root.right = bstNode(idx+1, right);
        root.left = bstNode(left, idx-1);
        return root;
    }
}
