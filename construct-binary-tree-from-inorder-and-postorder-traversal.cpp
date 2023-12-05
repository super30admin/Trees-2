/*
Use a recursive approach to construct a binary tree by selecting the root from the postorder traversal and dividing the inorder traversal into left and right subtrees.
Maintain a post_idx to keep track of the current root in the postorder array and an idx_map for efficient lookup of indices in the inorder array.
Recursively build left and right subtrees, excluding the root index in the inorder array, until the entire tree is constructed.
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once.
Space Complexity: O(N), where N is the number of nodes, for the unordered_map storing the inorder indices and the recursive call stack.*/
#include<bits/stdc++.h>
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
int post_idx;
    vector<int> postorder;
    vector<int> inorder;
    unordered_map<int, int> idx_map;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
         this->inorder = inorder;
        this->postorder = postorder;
        post_idx = postorder.size() - 1;

        int idx = 0;
        for (int val : inorder)
            idx_map[val] = idx++;

        return helper(0, inorder.size() - 1);
    }
     TreeNode* helper(int in_left, int in_right) {
        if (in_left > in_right)
            return nullptr;

        int root_val = postorder[post_idx];
        TreeNode* root = new TreeNode(root_val);

        int index = idx_map[root_val];

        post_idx--;

        root->right = helper(index + 1, in_right);
        root->left = helper(in_left, index - 1);

        return root;
    }
};