// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Traverse from root to the leaf recursively. 
// Multiply the curr value with 10 and add root value to it, where cur is the number being formed from root to leaf.

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
class Solution {
    public:
        int getSum(TreeNode* root, int cur){
            if(root == NULL) return 0;
            cur = cur*10 + root->val;
            if(root->left == NULL && root->right == NULL) return cur;
            return getSum(root->left, cur) + getSum(root->right, cur);
        }
        int sumNumbers(TreeNode* root) {
            return getSum(root,0);
        }
    };