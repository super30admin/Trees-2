// Problem 129. Sum Root to Leaf Numbers
// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class SumNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    private int helper(TreeNode root, int curr){
        // base
        if(root == null){
            return 0;
        }
        // logic
        curr = curr * 10 + root.val;
        // // preorder leaf check
        if(root.left == null && root.right == null){
            return curr;
        }
        int left = helper(root.left, curr);
        int right = helper(root.right, curr);
        return left+right;
    }
}
