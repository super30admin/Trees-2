// we solve this using preoder traversal. We will keep track of the current number formed by the path from root to leaf.
// When we reach a leaf node, we add the current number to the result.
// We will use recursion to traverse the tree. The base case is when the node is null, we return.

// Time : O(n)
// Space : O(h)


import java.util.*;

class Solution {
    int result;
    public int sumNumbers(TreeNode root) {
        this.result = 0;
        helper(root, 0);
        return result;
    }
    
    private void helper(TreeNode root, int curr) {
        // base case
        if(root == null) return;


        if(root.left == null && root.right == null) {
            result += curr * 10 + root.val;
        }
        curr = curr * 10 + root.val;

        helper(root.left, curr); // preorder manner

        helper(root.right, curr);
    }
}