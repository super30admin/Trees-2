#include<iostream>
#include<bits/stdc++.h>
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
/*
We use a void-based recursive helper to build numbers from root to leaf by multiplying the current number by 10 and adding the node value.
When we hit a leaf node, we add the current number to the result since it represents a full root-to-leaf path. The recursion continues down left and right children, accumulating the total sum along the way.
Here result is calculated in pre-order manner. It can also be accumulated in in-order or post-order manner.
*/
class Solution{
    int result;
public:
    int sumNumbers(TreeNode* root) {
        result=0;
        helper(root, result);
        return result;
    }
private:
    void helper(TreeNode* root, int currNum){
        if(root == nullptr) return;

        currNum = currNum*10 + root->val;
        if(root->left == nullptr && root->right == nullptr){
            result+=currNum;
        }
        helper(root->left, currNum);
        helper(root->right, currNum);
    }
};
