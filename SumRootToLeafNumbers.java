/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/*
    Leetcode problem 129: Sum Root to Leaf Numbers
    T.C: O(n) :: S.C: O(h) - height of the tree

    Solved using Recursive approach (DFS): Traverse from root to leaf by going left
    recursively and then return 0 if you reach a node that is null, this would serve
    as the base case. Then create the number formed until the leaf (num * 10 + root.val)
    and return this number. Add all the numbers that are called recursively until the leaf
    node (i.e root.left + root.right). To return the number that is formed at the leaf, we
    need to maintain a variable that holds the number formed from the root until the previous
    node in the helper method.
*/

class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        return helper(root, 0);
    }

    private int helper(TreeNode root, int num) {
        //Base case
        if (root == null) return 0;

        if (root.left == null && root.right == null) return num * 10 + root.val;

        //Logic - recursion
        return helper(root.left, num * 10 + root.val) + helper(root.right, num * 10 + root.val);
    }
}