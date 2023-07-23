//129. Sum Root to Leaf Numbers

// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        sum = 0;
        dfs(root, root.val);
        return sum;
    }
    private void dfs(TreeNode root, int value){
        if(root.left == null && root.right == null){
            sum = sum + value;
            return;
        }
        if(root.left != null){
            root.left.val = value*10 + root.left.val;
            dfs(root.left, root.left.val);
        }
        if(root.right != null){
            root.right.val = value*10 + root.right.val;
            dfs(root.right, root.right.val);
        }
    }
}