/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

 // Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }

    private int helper(TreeNode root , int currNum){
        //
        if(root == null) return 0;

        //logic
        currNum = currNum * 10 + root.val;
        if(root.left == null && root.right == null){
            return currNum;
        }
        int left = helper(root.left , currNum);
        int right = helper(root.right, currNum);

        return left + right;
    }
}

