/*
 ? Problem: Sum to root leaf numbers
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    int sum = 0;
    void dfs(TreeNode* root, int curr_num) {
        // base
        if (root == nullptr)
            return;

        // logic
        curr_num = curr_num*10 + root->val;
        if (root->left == nullptr && root->right == nullptr) {
            sum += curr_num;
        }

        dfs(root->left, curr_num);
        dfs(root->right, curr_num);
    }
public:
    int sumNumbers(TreeNode* root) {
        dfs(root, 0);
        return sum;
    }
};