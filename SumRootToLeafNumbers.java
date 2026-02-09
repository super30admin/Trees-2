// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1: To get the updated value at each node, we are multiplying by 10 and adding the value of the current node
// 2: If we reach a leaf node, the updated value is added and returned
// 3: Once all left and right paths are complete, we add the value and return the sum
class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        return helper(root, 0);
    }

    private int helper(TreeNode root, int currNum){
        // base
        if(root == null) return 0;

        // logic
        if(root.left == null && root.right == null){
            return currNum * 10 + root.val;
        }
        int left = helper(root.left, currNum * 10 + root.val);
        int right = helper(root.right, currNum * 10 + root.val);
        return left + right;
    }
}