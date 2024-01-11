
// Time Complexity : O(N)

// Space Complexity : O(N)

// Did this code successfully run on Leetcode : YES

// Appoarch: Using recursion and postorder traversal, calculating the currSum
// at each level and adding it once we reach the leaf node.

#include <bits/stdc++.h>
using namespace std;

 // Definition for a binary tree node.
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
    int idx;
    map<int,int> mp;
    TreeNode* helper(vector<int>& postorder,int start,int end,int& postIdx){
        if(start > end) return NULL;
        int rootVal = postorder[postIdx];
        postIdx--;
        int rootIdx = mp[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        root->right = helper(postorder,rootIdx+1,end,postIdx);
        root->left = helper(postorder,start,rootIdx-1,postIdx);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int n = inorder.size();
        int postIdx = postorder.size() - 1;
        for(int i=0;i<n;i++){
            mp[inorder[i]] = i;
        }
        return helper(postorder,0,n-1,postIdx);
    }
};