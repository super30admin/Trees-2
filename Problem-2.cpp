// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion and preorder traversal, calculating the currSum
// at each level and adding it once we reach the leaf node.

#include <bits/stdc++.h>
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
    int result;
    void helper(TreeNode* root, int currNum){
        if(root == NULL) return;
        currNum = currNum * 10 + root->val;
        helper(root->left,currNum);
        if(root->left == NULL && root->right == NULL){
            result += currNum;
        }
        helper(root->right,currNum);
    }
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return result;
    }
};