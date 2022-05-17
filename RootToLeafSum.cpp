// Time Complexity : o(n)
// Space Complexity : o(n)
// Where n = number of elements in the list given
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

class Solution {
public:
    vector<int> list;
    void helper(TreeNode *root, int num) {
        if(root==NULL) return;
        if(!root->left && !root->right) {
            num = num*10+root->val;
            list.push_back(num);
            return;
        }
        helper(root->left,num*10+root->val);
        helper(root->right,num*10+root->val);
    }
    int sumNumbers(TreeNode* root) {
        int sum= 0;
        helper(root, 0);
        for(auto &x:list) {
            sum+=x;
        }
        return sum;
    }
};