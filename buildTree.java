// Time Complexity : O(n) where n is the length of inorder or postorder
// Space Complexity : O(n) where n is the length of inorder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

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
    HashMap<Integer, Integer> map;
    int postorderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length-1;
        map = new HashMap<Integer, Integer>();
        
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        return helper(postorder, 0, postorder.length-1);
    }
    
    public TreeNode helper(int[] postorder, int start, int stop){
        if(start > stop){
            return null;
        }
        
        TreeNode root = new TreeNode(postorder[postorderIndex]);
        int inorderIndex = map.get(root.val);
        postorderIndex--;
            
        root.right = helper(postorder, inorderIndex+1, stop);
        root.left = helper(postorder, start, inorderIndex-1);
          
        return root;
    }
}