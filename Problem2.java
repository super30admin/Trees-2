// Time Complexity : O(N) -> N = no of nodes (visiting all once)
// Space Complexity : O(H) -> H = height of the tree
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Sum calculation

class Solution {
    public int sumNumbers(TreeNode root) {
        
        if (root == null) return 0;
        
        return addPathNumbers(root, 0);
    }
    
    private int addPathNumbers(TreeNode node, int curSum) {
        
        if (node == null) return 0;
        
        if (node.left == null && node.right == null) {
            return curSum * 10 + node.val;
        }
        
        int leftSum = addPathNumbers(node.left, curSum * 10 + node.val);
        
        int rightSum = addPathNumbers(node.right, curSum * 10 + node.val);
        
        return leftSum + rightSum;
    }
}