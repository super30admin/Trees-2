// Time Complexity : O(n), n = number of nodes in the tree
// Space Complexity : O(h), height of the tree, O(n) worst case, for recursion stack
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No

class Solution {
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return ans;
    }
    public void helper(TreeNode root, int sum){
        if(root == null){
            return;
        }
        sum = (sum*10) + root.val;
        if(root.left == null && root.right == null)
            ans += sum;          
        helper(root.left, sum);
        helper(root.right, sum);
        
    }
}
