//Time Complexity - O(n)
//Space Complexity - O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


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
   int idx; // preporder arr pointer
 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      if(preorder.length == 0) return null;
      map = new HashMap<>();
      
    //copy inorder elemnts in hashmap
      for(int i = 0; i< inorder.length; i++) {
        map.put(inorder[i] , i); // element and index
      }
       return helper(preorder,0, inorder.length-1);
      }
  
    private TreeNode helper(int[] preorder, int start, int end) {
      //base case
      if(start > end) return null;
      
      //logic
      int rootVal = preorder[idx];
      idx ++;
      TreeNode root = new TreeNode(rootVal);
      //get rootindex in from hashmap(in inorder traversal)
      int rootIdx = map.get(rootVal); // inorder index pointer
      root.left = helper(preorder,start, rootIdx-1);
      root.right = helper(preorder,rootIdx+1,end);
      return root;
      
    }
}