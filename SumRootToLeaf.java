// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null) return result;
        
        dfs(root, 0);
        return result;
    }
    
    private void dfs(TreeNode root, int sum) {
        if(root == null) return;
        
        if(root.left == null && root.right == null) {
            result += (sum * 10) + root.val;
        }
        
        sum = (sum *10) + root.val;
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}