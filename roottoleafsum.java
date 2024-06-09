
//Definition for a binary tree node.
// Time Complexity : O(n)
// Space Complexity : O(n) -> recursive stack space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum; // global variable 
    public int sumNumbers(TreeNode root) {
    sum = 0; //intializing sum to 0
    dfs(root, 0);
    return sum;
    }

    public void dfs(TreeNode root, int currSum){
        if(root == null){
            return; // base case
        }

        if(root.left == null && root.right == null){ // if we reach at the end(leaf), then sum up the current sum so far
            sum = sum + 10*currSum + root.val;
            return;
        }

        dfs(root.left, 10  * currSum + root.val); // traversing till one end, left
        dfs(root.right, 10 * currSum + root.val); // traversing till one end, right
    }
}