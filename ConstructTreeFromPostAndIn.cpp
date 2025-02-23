// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <unordered_map>

using namespace std;
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
    unordered_map<int, int> mp;
    int post;

    TreeNode* helper(vector<int>& postorder, int i, int j) {
        if (i>j) return nullptr;

        int rootV = postorder[post--];
        TreeNode* root = new TreeNode(rootV);
                root->right = helper(postorder, mp[rootV] +1, j);
        root->left = helper(postorder, i, mp[rootV] -1);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i=0; i<inorder.size(); i++) {
            mp[inorder[i]] = i;
        }
        post = postorder.size()-1;

        return helper(postorder, 0 , postorder.size()-1);
    }
};