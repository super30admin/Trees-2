
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// took currsum to store the sum till the leaf
// once leaf was reached added it to the total sum

class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {

        helper(root, 0);
        return sum;
    }

    public void helper(TreeNode root, int currSum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null) {
            sum = sum + currSum * 10 + root.val;
        }
        helper(root.left, currSum * 10 + root.val);
        helper(root.right, currSum * 10 + root.val);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// took currsum to store the sum till the leaf
// once leaf was reached added it to the total sum
// Return type as int
class Solution {
    int sum;

    public int sumNumbers(TreeNode root) {

        return helper(root, 0);
    }

    public int helper(TreeNode root, int currSum) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null) {
            return currSum * 10 + root.val;
        }
        return helper(root.left, currSum * 10 + root.val) + helper(root.right, currSum * 10 + root.val);
    }
}

// Time Complexity : O(n)
// Space Complexity : O(Height)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no

// Approach
// Have tried the recursive approach
// took currsum to store the sum till the leaf
// once leaf was reached added it to the total sum
// Iterative approach
class Solution {

    public int sumNumbers(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0, currSum = 0;
        Stack<TreeNode> s = new Stack();
        Stack<Integer> num = new Stack();
        while (root != null || !s.isEmpty()) {
            while (root != null) {
                currSum = currSum * 10 + root.val;
                s.push(root);
                num.push(currSum);
                root = root.left;
            }
            root = s.pop();
            currSum = num.pop();
            if (root.left == null && root.right == null) {
                sum = sum + currSum;
            }
            root = root.right;
        }
        return sum;
    }

}