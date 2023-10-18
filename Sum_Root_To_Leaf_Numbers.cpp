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
int result=0;
public:
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return result;
    }
    void helper(TreeNode* root, int CurrSum){
        // base case
        if(root==NULL)return;

        //logic 
        CurrSum = CurrSum*10 + root->val;
        if(root->left==NULL && root->right==NULL){
            result += CurrSum;
        }
        helper(root->left, CurrSum);
        helper(root->right, CurrSum);

    }
};
