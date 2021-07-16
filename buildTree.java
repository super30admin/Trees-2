// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


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
    int post_idx;
    int[] postorder;
    int[] inorder;
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
  
    public TreeNode helper(int in_left, int in_right) {
      
    if (in_left > in_right)
        return null;
  
      int root_val = postorder[post_idx];
      TreeNode root = new TreeNode(root_val);
  
      int index = indexMap.get(root_val);
  
      // recursion 
      post_idx--;
      // build right subtree
      root.right = helper(index + 1, in_right);
      // build left subtree
      root.left = helper(in_left, index - 1);
      return root;
    }
  
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      this.postorder = postorder;
      this.inorder = inorder;
     
      post_idx = postorder.length - 1;
  
      int idx = 0;
      for (Integer val : inorder)
        indexMap.put(val, idx++);
      return helper(0, inorder.length - 1);
    }
  }