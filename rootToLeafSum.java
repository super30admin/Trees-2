// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int sumNumbers(TreeNode root) {
       return helper(root,0);
       
    }
    public int helper(TreeNode root, int sum){
        
        if(root == null) return 0;
        
        if(root.left == null && root.right == null){
            return sum = sum*10 + root.val;
        }
        
        int left = helper(root.left, sum*10 + root.val);
        int right = helper(root.right, sum*10 + root.val);
        
        return left + right;
    }
}