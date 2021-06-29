// Time Complexity : O(n)
// Space Complexity : O(n)  //  recursive stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Construct Binary Tree from Inorder and Postorder Traversal

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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        // First find the root which is the last element of postorder.
        // Then find the root element in inorder and its left and right child 
        int size = inorder.size();
        return buildTree(inorder, postorder, 0, size - 1, 0, size - 1); // Recursively build the tree and return the root.
    }
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder, int inLeft, int inRight, int postLeft, int postRight)
    {
        if (inLeft > inRight)
        {
            return nullptr;
        }
        
        int rootVal = postorder[postRight], inMid = inLeft;
        while (inMid <= inRight && inorder[inMid] != rootVal)
        {
            ++inMid;
        }
        
        TreeNode* left = buildTree(inorder, postorder, inLeft, inMid - 1, postLeft, postLeft + inMid - 1 - inLeft);
        TreeNode* right = buildTree(inorder, postorder, inMid + 1, inRight, postLeft + inMid - inLeft, postRight - 1);
        return new TreeNode(rootVal, left, right);
    }
};