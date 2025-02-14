// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


/*
Using recursion we go in left subtree and right subtree, whenever we find leaf node we add that path sum to total sum.
*/
class SumRootToLeafNumber {
   private int sum=0;
   public int sumNumbers(TreeNode root) {
       helper(root,0);
       return sum;
   }

   private void helper(TreeNode root,int val){
       if(root==null){
           return;
       }
       int curr=val*10+root.val;
       if(root.left==null && root.right==null){
           sum=sum+curr;
           return;
       }
       
       helper(root.left,curr);
       
       helper(root.right,curr);
   }
}