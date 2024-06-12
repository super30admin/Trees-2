// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    HashMap<Integer , Integer> map;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length == 0 || inorder.length == 0)return null;
         index = postorder.length-1;
        map = new HashMap<>();
        for(int i = 0; i < inorder.length ; i++){
            map.put(inorder[i],i);
        }
       
        return helper(postorder, inorder, 0, inorder.length-1);
    }
    private TreeNode helper(int[] postorder, int[] inorder, int start, int end){
        
        if(start>end ||index < 0)return null;
        
        int inIdx = map.get(postorder[index]);
        TreeNode root = new TreeNode(postorder[index]);
        index --;
        root.right = helper(postorder, inorder , inIdx + 1 ,end);
        root.left = helper(postorder, inorder , start ,inIdx - 1);
        
        return root;
        
    }
}