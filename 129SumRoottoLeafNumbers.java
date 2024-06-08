//Sum-to root Time Complexity O(N) and space complexity O(H)

## Problem2 (https://leetcode.com/problems/sum-root-to-leaf-numbers/)

# Approach
# Traverse from root to leaf node. At each node, add the value to curSum. curSum = curSum * 10 + root.val. check if the node is a leaf node using if root.left == None and root.right == None.
# If yes, add the curSum to res else continue traversing through the tree. Recursively call the left and right child and pass node and curSum to the function
# return root

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
        helper(root,0);
        return sum;
    }

     public void helper(TreeNode root,int curr){
        if(root==null) return;
          curr = curr*10+root.val;
        if(root.left==null && root.right==null){
            sum +=curr;
        }
        helper(root.left,curr);

         helper(root.right,curr);
     }

}
