// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    
    int add(TreeNode *root,int num)
    {
        if(root==NULL)
        {
            return 0;
        }
        
        num=num*10+root->val;
        
        if(root->left==NULL && root->right==NULL)
            return num;
        
        return add(root->left,num)+add(root->right,num);
    }
    
    int sumNumbers(TreeNode* root) {
        
        int answer=add(root,0);
        return answer;
    }
};