// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: 129: Sum root to leaf numbers
// Approach: DFS
// Time Complexity: O(n)
// Space Complexity: O(h)

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution
{
public:
    // Global Variable
    int currentSum = 0;

    int sumNumbers(TreeNode *root)
    {

        // Base Case
        if (root == NULL)
        {
            return 0;
        }

        dfs(root, 0);

        return currentSum;
    }

    void dfs(TreeNode *root, int sum)
    {
        // Base Case
        if (root == NULL)
        {
            return;
        }

        // If leaf node then to current sum add the value of root, as we have to append value for every depth
        // We multiply by 10 and add the current root value
        if (root->left == NULL && root->right == NULL)
        {
            currentSum = currentSum + sum * 10 + root->val;
        }

        // Continue DFS for childs
        dfs(root->left, sum * 10 + root->val);
        dfs(root->right, sum * 10 + root->val);

        return;
    }
};