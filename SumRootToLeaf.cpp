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
    vector<string> answer;
    int sumNumbers(TreeNode* root) {
        helper(root, "");
        int result=0;
        for (string s:answer) {
            result+= std::stoi(s);
        }
        return result;
    }

    void helper(TreeNode* root, string currSum) {
        if (root == NULL) return;

        if (root->left == NULL && root->right == NULL) {
            currSum+=std::to_string(root->val);
            answer.push_back(currSum);
        }
        currSum+=std::to_string(root->val);

        helper(root->left, currSum);
        helper(root->right, currSum);
    }
};
