// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

public class RootSum {
    public int sumNumbers(TreeNode root) {
    
         
        return helper(root,0);
   }

   public int helper(TreeNode root,int currNum){
       if(root==null) return 0;

       currNum = currNum*10 + root.val;
       int left = helper(root.left,currNum);
       if(root.left ==null && root.right==null){
           return currNum;
       }
      
       int right = helper(root.right,currNum);

       return left+right;
   }

}
