// Time Complexity : O(n)
// Space Complexity : O(n) with recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
 
    int output = 0;
        
    myrecurr(root,0,output);
    return output;
        
    }
    
    void myrecurr(TreeNode* root, int prev, int &output){
        if(root == NULL) return;
        
        int current = prev*10 + root->val;
        
        if (root->left == NULL && root->right==NULL){
            output += current;
            return;
        }
        myrecurr(root->left, current, output);
        myrecurr(root->right, current, output);

    }
};