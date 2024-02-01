// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Idea here is to recursively calculate sum from root to all leaf nodes. Sum calculated at each level is
// sent as function args. When we reach leaf node, add that curr sum to result and return result at the end.

#include <stack>

//Definition for a binary tree node.
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
public:
    int result = 0;
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return result;
    }
    void helper(TreeNode* root, int currNum)
    {
        if(root == nullptr)
        {
            return;
        }

        currNum = currNum*10 + root->val;
        if(root->left == nullptr && root->right == nullptr)
        {
            result += currNum;
        }
        helper(root->left, currNum);
        helper(root->right, currNum);
    }
};