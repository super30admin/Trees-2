//Time Complexity and Space Complexity : O(n)
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
public:
    int ans=0;
    int sumNumbers(TreeNode* root) {
        helper(root,0);
        return ans;
    }
    void helper(TreeNode* root , int currsum){
        if(root == nullptr)
            return;
        currsum = currsum * 10 + root->val;
        if(root->left == nullptr && root->right == nullptr){
            ans+= currsum;
        }
        helper(root->left,currsum);
        helper(root->right,currsum);
    }
};