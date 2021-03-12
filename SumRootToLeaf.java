// Time Complexity :O(N)
// Space Complexity :O(H)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No 


// Your code here along with comments explaining your approach
//In this approach we use recursion where we keep on traversing to the leaf node and appending it to the current number. In the recursion stack
//we keep doing this for left child and right child of each node
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
  
    int output = 0;
    public int sumNumbers(TreeNode root) {
        
      if(root == null)
      {
        return output;
        
      }
      rootToLeaf(root,0);
      return output;
    }
  
    private void rootToLeaf(TreeNode root,int current)
    {
      if(root == null)
      {
        return;
      }
      //adding number as the last digit
      current = current * 10 + root.val;
      //when we hit the lead node
      if(root.left==null && root.right== null)
      {
        output = output + current;
        return;
      }
      rootToLeaf(root.left,current);
      rootToLeaf(root.right,current);
    }
}