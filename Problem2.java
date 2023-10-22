// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
      helper(root,0);
      return sum;  
    }
    private void helper(TreeNode root,int curr){
        if(root == null)
            return;
        curr = curr*10 + root.val;
        if(root.left == null && root.right==null)
            sum+=curr;
        helper(root.left,curr);
        helper(root.right,curr);
    }
}