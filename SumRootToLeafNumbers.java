// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to revise basic syntax

// ## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

// You are given the root of a binary tree containing digits from 0 to 9 only.
// Each root-to-leaf path in the tree represents a number. For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
// Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
// A leaf node is a node with no children.

// Example 1:
// Input: root = [1,2,3]
// Output: 25
// Explanation:
// The root-to-leaf path 1->2 represents the number 12.
// The root-to-leaf path 1->3 represents the number 13.
// Therefore, sum = 12 + 13 = 25.

// Example 2:
// Input: root = [4,9,0,5,1]
// Output: 1026
// Explanation:
// The root-to-leaf path 4->9->5 represents the number 495.
// The root-to-leaf path 4->9->1 represents the number 491.
// The root-to-leaf path 4->0 represents the number 40.
// Therefore, sum = 495 + 491 + 40 = 1026.

// Constraints:
// The number of nodes in the tree is in the range [1, 1000].
// 0 <= Node.val <= 9
// The depth of the tree will not exceed 10.

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
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        // Base case: if tree is empty
        if (root == null){
            return 0;
        }

        // Starting DFS Traversal with current sum = 0
        dfs(root, 0);

        return sum;
    }
    
    // DFS Helper function to traverse tree and calculate root-to-leaf numbers
    private void dfs(TreeNode root, int currSum){
        // Base case: reached null node
        if (root == null){
            return;
        }

        // Left recursive call
        dfs(root.left, currSum * 10 + root.val);

        // If the leaf node is reached, adding current path's number to total sum
        if(root.left == null && root.right == null){
            sum = sum + currSum * 10 + root.val;
            return;
        }

        // Right recursive call
        dfs(root.right, currSum * 10 + root.val);
    }
}