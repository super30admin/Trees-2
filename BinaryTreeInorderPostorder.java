// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// Here we are using the recursive approach. We start from the last index of the postorder traversal which is the root.WE take that root and search
//for it in the inorder array , the elemnts to the left become the left subtree and the ones to the right become the right subtree.
//we keep decrementing the root and keep passing the right and left to the method recursively.

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
      
      HashMap<Integer,Integer> map = new HashMap<>();
      int postIndex ;
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
     
      postIndex = postorder.length-1;
      
      for(int i = 0 ;i<inorder.length;i++)
      {
        map.put(inorder[i],i);
      }
      
      return buildTree(inorder,postorder,0,inorder.length-1);
    }
  
  private TreeNode buildTree(int[] inorder,int[] postorder,int inStart,int inEnd)
  {
    if(inStart>inEnd)
    {
      return null;
    }
    TreeNode root = new TreeNode(postorder[postIndex]);
    postIndex--;
    
    int index = map.get(root.val);
    root.right=buildTree(inorder,postorder,index+1,inEnd);
    root.left=buildTree(inorder,postorder,inStart,index-1);
    
    return root;
  }
}