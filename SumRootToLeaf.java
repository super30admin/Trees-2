// Time O(n)
//Space O(1)
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

class Solution { int result; //global variable
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return result;
    }
   private void helper(TreeNode root, int curr)
   {
       if(root==null)
           return;
       if(root.right==null && root.left==null) //leaf node
           result+= (curr*10+root.val);
       
       helper(root.left,curr*10+root.val);
       helper(root.right,curr*10+root.val);
       
       
   }
}