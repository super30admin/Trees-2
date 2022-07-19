//Time Complexity- O(n)
//Space Complexity- O(h) where h is the depth of the tree
//Successfully ran on leetcode

class Solution {
 int sum;
 public int sumNumbers(TreeNode root) {
     
     if(root==null) return sum;
     
     helper(root, 0);
     
     return sum;
     
 }
 private void helper(TreeNode root, int num){
     
     if(root == null) return;
     
     if(root.left ==null && root.right==null){
         sum= sum + num*10 + root.val;
         return;
     }
     helper(root.left, num*10 +root.val);
     helper(root.right, num*10 +root.val);
     
 }
}