/*
Time Complexity - O(n)
Space Complexity - O(n)
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
    int idx;
    int[] inorder;
    int[] postorder;
    HashMap<Integer, Integer> hmap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder = inorder;
        this.postorder = postorder;
        this.idx = postorder.length-1;
        
        int idx = 0;
        for(int val : inorder)
        {
            hmap.put(val,idx++);
        }
        return helper(0,inorder.length-1);
        
    }
    
    private TreeNode helper(int left, int right)
    {
        if(left>right)
            return null;
        int root_val = this.postorder[idx--];
        int index = hmap.get(root_val);
        TreeNode root = new TreeNode(root_val);
        
        root.right = helper(index+1,right);
        root.left = helper(left, index-1);
        return root;
    }
}