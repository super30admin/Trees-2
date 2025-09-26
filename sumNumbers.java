// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int currNum){
        // base case
        if(root == null) return;

        currNum = currNum * 10 + root.val;

        if(root.left == null && root.right == null){
            result += currNum;
        }

        helper(root.left, currNum);

        helper(root.right, currNum);
    }
}
