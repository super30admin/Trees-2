// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
    HashMap<Integer,Integer> map;
     int idx;
     public TreeNode buildTree(int[] inorder, int[] postorder) {
         map = new HashMap<>();
         idx = postorder.length-1;
         for(int i =0;i<inorder.length;i++){
             map.put(inorder[i],i);
         }
         return helper(postorder,0,postorder.length-1);
     }
     private TreeNode helper( int[] postorder, int start, int end){
         if(start>end){
             return null;
         }
         TreeNode root = new TreeNode(postorder[idx]);
         idx--;
         int rootidx = map.get(root.val);
         root.right = helper(postorder,rootidx+1,end);
         root.left = helper(postorder,start,rootidx-1);
         return root;
     }
 }