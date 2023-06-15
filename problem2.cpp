/**
// Time Complexity : O(N)
// Space Complexity : O(H)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : condition when one of the child is null and other is not.


// Your code here along with comments explaining your approach
*/



#include<iostream>
#include<vector>

using namespace std;


struct TreeNode{
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x,TreeNode* left,TreeNode* right):val(x),left(left),right(right){};
    TreeNode():val(0),left(nullptr),right(nullptr){};
    TreeNode(int x):val(x),left(nullptr),right(nullptr){};

};


class Solution {
public:
    int sum{};
    void helper(TreeNode* root,int curr_num){
        //base
        if(root == nullptr) return; // there is a possibility either left or right child is null;
        curr_num = curr_num*10+root->val;
        if(root->left == nullptr && root->right == nullptr){
            sum+= curr_num;
            return;
        }

        helper(root->left,curr_num);
        helper(root->right,curr_num);

    }
    int sumNumbers(TreeNode* root) {
        helper(root,0);
        return sum;
    }
};