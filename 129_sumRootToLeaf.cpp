// Time Complexity : O(N) where N is the number of nodes.
// Space Complexity :O(H) where h is the number of levels of tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    int sum=0;
    int sumNumbers(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        helper(root, 0);
        return sum;
    }
    void helper(TreeNode * root, int currSum){
        if(root == NULL)
            return;
        currSum = currSum * 10 + root->val;
        helper(root->left, currSum);
        if(root->left == NULL && root->right == NULL){
            sum += currSum;
        }
        helper(root->right, currSum);
    }
};
