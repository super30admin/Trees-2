// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes

class Solution {
public:
    int sum=0;
    void updateSum(TreeNode* root,int cursum)
    {
        if(root==nullptr)
        {
            return;
        }
        
        if(root->left==nullptr && root->right==nullptr)
        {
            sum=sum+(cursum*10+root->val);
        }
        updateSum(root->left,(cursum*10+root->val));
        updateSum(root->right,(cursum*10+root->val));
    }
    int sumNumbers(TreeNode* root) {
        if(root==nullptr)
        {
            return 0;
        }
        updateSum(root,0);
        return sum;
    }
};
