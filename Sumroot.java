// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
//we kept global sum to calculate sum at each node and we are passing the same sum to the right and left tree 


 //Definition for a binary tree node.
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
    int output = 0;
    public int sumNumbers(TreeNode root) {
        if(root==null){
            return output;
        }
        recurrsive(root,0);
        
        return output;
        
    }
    private void recurrsive(TreeNode root,int prev){
        if(root==null){
            return;
        }
        
        int curr = prev*10+root.val;
        
        if(root.left==null&&root.right==null){
            output+=curr;
        }  
        
        recurrsive(root.left,curr);
        recurrsive(root.right,curr);
    }
}