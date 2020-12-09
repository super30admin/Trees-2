// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Do inorder traversal by strong the sum we have seen till then.

class Solution {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        
        traverse(root, 0);
        
        return sum;
    }
    
    public void traverse(TreeNode node, int tempSum) {
        
        if(node == null)
            return;
        
        tempSum = tempSum * 10 + node.val;
        
        if(node.left == null && node.right == null)
            sum += tempSum;
        
        traverse(node.left, tempSum);
        traverse(node.right, tempSum);
        
    }
    
}