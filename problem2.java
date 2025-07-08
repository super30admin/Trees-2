// Time Complexity : O(n)
// Space Complexity : O(height) for the recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: when left and right are null, it means it is leaf, so there I return sum*10 + node value. Every step that I go down, I add node's value to sum and multiply it by 10 to form the number. If the node goes down like 1,2. Then first sum is 0 so, multiply by 10 and add 1, so it becomes 1, then multiply by 10 and add 2 so becomes 12. I do this for left and right subtree and get the final answer.

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    public int helper(TreeNode node, int sum){
        if(node == null) return 0;
        if(node.left == null && node.right == null) return sum*10 + node.val;
        int left = helper(node.left, sum*10+node.val);
        int right = helper(node.right, sum*10+node.val);
        return left+right;
    }
}