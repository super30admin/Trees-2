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
//Time Complexity-O(n)
//Space complexity-O(1)
class Solution {
    int output=0;
    public int sumNumbers(TreeNode root) {
        int sum=0;
        recur(root,sum);
        return output;
    }
   private void recur(TreeNode root,int sum)
   {
       if(root==null)
       {
           return;
       }
       int cursum=root.val+sum*10;
       if(root.left==null&&
         root.right==null)
       {
           output+=cursum;
           return;
       }
       recur(root.left,cursum);
       recur(root.right,cursum);
   }
}