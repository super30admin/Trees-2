// Time Complexity : O(n)
// Space Complexity : O(h)
//    where h : height of tree 
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Perform DFS operation. While traversing a tree, maintain and pass variable 's'. 
 * For each recursive call multiply passed variable by 10 and add current node value to that variable and pass that variable to child nodes.
 * If current node is child node then return the s * 10 + current_node_value.      
 */

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
    int sumNumbers(TreeNode* root) {
        if (root == nullptr)
            return 0;
        return helper(root, 0);
    }
    int helper(TreeNode* root, int s)
    {
        if (root == nullptr)
            return 0;
        
        if (root->left == nullptr && root->right == nullptr)
        {
            return  s*10 + root->val;
        }
        return helper(root->left, ((s*10) + root->val)) + helper(root->right, ((s*10) + root->val));
    }
};