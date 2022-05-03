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
    int sum = 0;
    int sumNumbers(TreeNode* root) {
        
        if(root == NULL) return 0;
        
        helper(root,0);
        return sum;
    }
    
    void helper(TreeNode* root,int currentSum) {
        
        if(root == NULL) return;
        
        if(root->left == NULL && root->right == NULL) {
            
            sum = sum + currentSum*10+root->val; 
            return;
        }
        //logic 
        helper(root->left,currentSum*10+root->val);
        
       
        helper(root->right,currentSum*10+root->val);
    }
};