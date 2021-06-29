// Time Complexity : O(n)
// Space Complexity : O(n)  //  recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Sum root to leaf numbers

#include<iostream>
#include<vector>

using namespace std;
struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    private:
        int sum = 0;
    public:
        int sumNumbers(TreeNode* root) {
        
            if(root == NULL)
                return 0;
        
            helper(root, 0);
            return sum;
        }
    
    void helper(TreeNode *root, int currSum){
        
        if(root == NULL)
            return;
        
        currSum = currSum * 10 + (root->val);
        
        helper(root->left, currSum);
        
        
        helper(root->right, currSum);
        
        if(root->left == NULL && root->right == NULL)
            sum = sum + currSum;
    }
};