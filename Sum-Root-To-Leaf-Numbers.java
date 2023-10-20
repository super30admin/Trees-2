// Time Complexity :O(n)
// Space Complexity : O(h) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No




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
    int result=0;        

    public int sumNumbers(TreeNode root) {
    helper(root, 0) ;  
    return result;
    }
    
    private void helper(TreeNode root, int currNumber){
    
    if(root == null) return;
    currNumber = currNumber*10 + root.val;
    System.out.println("root" + root.val + " sum" + currNumber);    
    if(root.left ==null && root.right ==null){
     result+= currNumber;
    }
    helper(root.left,currNumber);
    helper(root.right,currNumber);

      
        
    }

}
