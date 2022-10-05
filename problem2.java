public class problem2 {

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    
    public int helper(TreeNode root, int sum){
        //base
        if(root == null) return 0;
        
        //logic
        if(root.left == null && root.right == null){
            return sum*10 + root.val;
        }
        
        int left = helper(root.left, sum*10+root.val);
        int right = helper(root.right, sum*10+root.val);
        
        return left + right;
        
    }
}
}
