// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // intialize sum
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        // if tree is empty, return 0
        if(root == null) return 0;
        // call the recursive function and return the calculated sum
        helper(root, 0);
        return sum;
    }
    private void helper(TreeNode root, int num){
        // if lead node is reached
        if(root == null) return;
        // calculate sum for left children nodes
        helper(root.left, num * 10 + root.val);
        // update the sum when leaf node is reached
        if(root.left == null && root.right == null){
            sum += num * 10 + root.val;
        }
        // calculate sum for right children nodes
        helper(root.right, num * 10 + root.val);
    }
}