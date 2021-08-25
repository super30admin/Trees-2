//Time Complexity - O(n)
//Space Complexity - O(HeightOfTree)
class Solution {
public:
    int sum;
    void helper(TreeNode* root, int currSum){
        if(root==NULL)
            return;
        currSum=currSum*10 + root->val;
        helper(root->left,currSum);
        if(root->left==NULL&&root->right==NULL)
            sum+=currSum;
        helper(root->right,currSum);
    }
    int sumNumbers(TreeNode* root) {
        if(root==NULL)
            return 0;
        helper(root,0);
        return sum;
    }
};