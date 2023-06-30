// Time Complexity : O(h)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

//Implementing a tree class
class TreeNode {
public:
    int val;
    TreeNode* left;
    TreeNode* right;

    TreeNode(int val) : val(val), left(nullptr), right(nullptr) {}
};

//using postorder we find the root and then find root in inorder and find the left sub tree and right subtree and repeat
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        //base
        if(postorder.size() == 0 || inorder.size() == 0) return NULL;

        //logic
        int rootval = postorder[postorder.size() - 1];
        TreeNode* root = new TreeNode(rootval);
        int idx;
        for(int i = 0; i < inorder.size(); i++){
            if(inorder[i] == rootval){
                idx = i;
                break;
            }
        }

        vector<int> inLeft(inorder.begin(), inorder.begin() + idx);
        vector<int> inRight(inorder.begin() + idx + 1, inorder.end());
        vector<int> postLeft(postorder.begin(), postorder.begin() + inLeft.size());
        vector<int> postRight(postorder.begin() + inLeft.size(), postorder.end() - 1);
        
        root->left = buildTree(inLeft, postLeft);
        root->right = buildTree(inRight, postRight);
        
        return root;
    }
};