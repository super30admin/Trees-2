// Time Complexity : O(n)
// Space Complexity : O(H), H = Height of the tree
// Did this code successfully run on Leetcode : Yes
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        helper(root, 0);
        return result;
    }
    private void helper(TreeNode root, int sum) {
        //base case
        if(root == null)
            return;
        
        sum = sum*10 + root.val;
        helper(root.left, sum);
        if(root.left == null && root.right == null)
            result += sum;
        helper(root.right, sum);
    }
}