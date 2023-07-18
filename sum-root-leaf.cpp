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

    int sum;
    int sumNumbers(TreeNode* root) {
        tree(root,0);
        return sum;
    }
        
    void tree(TreeNode* root, int num){
        if(root == NULL){
            return;
        }
        num = num*10+root->val;
        tree(root->left,num);
        tree(root->right,num);
        if(root->left == NULL && root->right == NULL){
            sum =sum + num;
        }      
    }
    
    
};