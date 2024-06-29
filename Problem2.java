// Time Complexity : o(n)
// Space Complexity : o(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// logic: It starts with the root node and performs a depth-first search (DFS), maintaining the current number formed by the path from the root.
//When a leaf node is reached, it adds the number formed by the path to the sum.
//The DFS continues recursively for left and right children, updating the current number by appending the node's value.

class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root == null){
            return 0;
        }
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    private void dfs(TreeNode root, int currNum){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            sum = sum + currNum * 10 + root.val;
            return ;
        }
        dfs(root.left, currNum * 10 + root.val);
        dfs(root.right, currNum * 10 + root.val);
    }
}