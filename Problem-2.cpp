// Time Complexity : O(n) where n is number of nodes in the tree, this is becuase we're just doing preorder traversal and computing result
// Space Complexity : O(h) h is height of the tree and this is space reqrd for recursion stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach

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
    int ans;
public:
    int sumNumbers(TreeNode* root) {
        int curr_num = 0;
        ans = 0;
        preorder(root, curr_num);
        return ans;
    }

    void preorder(TreeNode* root, int curr_num)
    {
        if(root == NULL)
            return;
        
        if(root->left == NULL && root->right == NULL)
            ans = ans+(curr_num*10)+root->val;

        preorder(root->left, (curr_num*10)+root->val);
        preorder(root->right, (curr_num*10)+root->val);
    }
};