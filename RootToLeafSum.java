// Time Complexity : O(n).
// Space Complexity : O(h) recursive stack space.
// Did this code successfully run on Leetcode : Yes
// Approach : The use a void based recursive helper function to maintain currSum at each recursive step and update the result calculate when leaf node is found.

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currSum){
        //base case
        if(root == null){
            return;
        }
        //logic
        currSum = currSum*10 + root.val; //calculate currSum
        if(root.left == null && root.right == null){
            result += currSum; //calculate total sum in result
        }
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}