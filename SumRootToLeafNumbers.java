// Time Complexity : O(N)
// Space Complexity : O(H) : H = height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
// Recursively calculate the sum by adding the current root value and multiplying the current sum by 10 for all the nodes in the tree
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        return calc(root, 0);
    }
    
    private int calc(TreeNode root, int sum){
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return root.val + sum*10;
        
        return calc(root.left, sum*10 + root.val) + calc(root.right, sum*10 + root.val);
    }
}