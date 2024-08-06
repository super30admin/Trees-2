// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


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
    Map<Integer, Integer> hashmap;
    int index;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
      int n = inorder.length;
      hashmap = new HashMap<>();
      index = n-1;
      for(int i = 0; i<n; i++) {
        hashmap.put(inorder[i], i);
      }
      return helper(postorder, 0, n-1);
    }
  
    TreeNode helper(int[] postorder, int start, int end) {
      if(start>end) return null;
      int rootValue = postorder[index];
      index--;
      TreeNode root = new TreeNode(rootValue);
      int rootIndex = hashmap.get(rootValue);
      root.right = helper(postorder, rootIndex+1, end);
      root.left = helper(postorder, start, rootIndex-1);
      return root;
    }
  }