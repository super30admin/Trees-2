// Time Complexity : O(n)
// Space Complexity : O(h) where h = height of tre (stack space for recurrsion)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        int ans = 0;
        dfs(root,ans,0);
        return ans;
    }
    
    void dfs(TreeNode* root, int &ans, int temp)
    {
        if(root->left ==0 && root->right ==0)
        {
            temp = temp*10 + root->val;
            ans+=temp;
            return; 
        }

        temp = temp*10 + root->val;
        if(root->left)
            dfs(root->left,ans,temp);
        if(root->right)
            dfs(root->right,ans,temp);

    } 

};