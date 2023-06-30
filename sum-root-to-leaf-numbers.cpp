// Time Complexity : O(n)
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

// taking global and local sum to calculate sum during recursion and then adding it to the global sum for each brach traversal.
class Solution {
private:
    int globalSum = 0;
public:
    int sumNumbers(TreeNode* root) {
        helper(root, 0);
        return globalSum;
    }
    void helper(TreeNode* root, int localSum){
        if(root == nullptr) return;
        if(root->left == nullptr && root->right == nullptr){
            // if(root->left == nullptr && root->right == nullptr){
            //     globalSum += localSum;
            // }
            localSum = localSum*10 + root->val;
            globalSum += localSum;
            // cout << globalSum <<"\n";
            return;
        }

        //left
        // cout << root->val;
        localSum = localSum*10 + root->val;
        cout << localSum << "\n";
        helper(root->left, localSum);

        //right
        // cout << root->val;
        // localSum += 10*root->val;
        helper(root->right, localSum);
        // localSum += 10*root->val;

    }
};