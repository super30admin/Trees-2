// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    int result = 0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return this.result;
    }
    private void helper(TreeNode root,int currSum){
        if(root == null) return;
        currSum = currSum * 10 + root.val;
        if(root.left == null && root.right == null){
            this.result+=currSum;
        }
        helper(root.left,currSum);
        helper(root.right,currSum);
        
        
    }
}
