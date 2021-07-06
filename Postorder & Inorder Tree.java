// Time Complexity : O(n) 
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


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
    HashMap<Integer, Integer> result;
    int postIdx;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIdx = inorder.length - 1;
        result = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            result.put(inorder[i], i);
        }
        return helper(postorder, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        //base
        if(start > end) return null;
        
        //logic
        TreeNode root = new TreeNode(postorder[postIdx]);
        int inorderIdx = result.get(root.val);
        postIdx--;
        root.right = helper(postorder, inorder, inorderIdx + 1, end);
        root.left = helper(postorder, inorder, start , inorderIdx - 1);
        
        
        return root;
    } 
}