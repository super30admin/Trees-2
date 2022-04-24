/**
Problem: https://leetcode.com/problems/sum-root-to-leaf-numbers/
TC: O(n) where n is the total number of nodes in the tree
SC: O(1)
*/

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

// Approach 1: Recursive
class Solution {
    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        traverse(root, 0);
        return totalSum;	
    }

    private void traverse(TreeNode root, int curSum) {
        if (root == null) return;

        curSum = curSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            totalSum += curSum;
            return;
        }
        traverse(root.left, curSum);
        traverse(root.right, curSum);
    }
}

// Approach 2: Iterative
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        Stack<TreeNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        int num = 0, sum = 0;
        
        while (!st1.isEmpty() || root != null) {
            if (root != null) {
                st1.push(root);
                num = num * 10 + root.val;
                st2.push(num);
                root = root.left;
            } else {
                root = st1.pop();
                num = st2.pop();
                if (root.left == null && root.right == null) {
                    sum = sum + num;
                }
                root = root.right;
            }
        }
        return sum;
    }