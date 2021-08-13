// Time Complexity : O(N)
// Space Complexity : o(h) -> height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*Approach
1) use a global variable gSum and a local variable sum
2)traverse through the tree and calculate the sum at current node
3) then move to left and then move to right 
4) if the node == null we return and check for the parent value
5) then we check if its a leaf node, we update the current value and parent value



*/

/**
 * Definition for a binary tree node.
 * */
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
 
class Solution {
    
    int gSum=0;
    public int sumNumbers(TreeNode root) {
     
     if(root==null)
         return 0;
        
         helper(root,0);
        
        return gSum;
        
    }
    
    public void helper(TreeNode root,int sum)
    {
        if(root==null)
        {
            return;
        }
        
        
        // logic
        sum = sum*10 + root.val;
       // gSum+=sum;
        
        helper(root.left,sum);
        
        if(root.left==null && root.right==null)
        {
            gSum+=sum;
        }
        
        helper(root.right,sum);
    }
}