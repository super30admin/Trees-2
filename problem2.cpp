// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// We add the sum to our answer whenever we reach the leaf node. remaining all cases, we just do sum= sum*10 + root->val;
// we traverse to each and every node.


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
   // int ans=0;
    void f(TreeNode* root,int sum,int & ans)
    {
        if(root==NULL){
            return ;
        }
        sum= sum*10 + root->val;
        if(root->left==NULL && root->right==NULL)
        {
            ans+= sum;
            return ;
        }
        f(root->left,sum,ans);
        f(root->right,sum,ans);
    }
    int sumNumbers(TreeNode* root) {
        if(root ==NULL){
            return 0;
        }
        int ans =0;
        f(root,0,ans);
       return ans; 
    }
};