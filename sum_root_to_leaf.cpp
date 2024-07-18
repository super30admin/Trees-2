/*
 *          
 *                          Sum Root to Leaf Numbers
 *
 * 
 *  Leetcode link            :  https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
 *  Time Complexity          : O(n) where n is the number of nodes
 *  Space Complexity         : O(1) is the auxillary space and O(h) where h is the height of the tree due to the recurcive stack calls
 *  Did this run on leetcode : Yes
 *  Approach                 : Calculates the sum of all root-to-leaf paths in a binary tree using 
 *                             depth-first traversal and integer manipulation to construct and 
 *                             accumulate path values.
 */

 
#include<iostream>
#include<unordered_map>
#include<vector>

using namespace std;

/*
 * Definition for a binary tree node.
 */
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
    // Storing the final result
    int result;

    int sumNumbers(TreeNode* root) {
        traverse(root, 0);
        return result;
    }

    // Helper function to traverse over the tree
    void traverse(TreeNode* root, int currNum) {
        // Base
        if (root == NULL) return;

        // Logic
        currNum = currNum*10 + root->val;
        if (root->left == NULL and root->right == NULL) {
            result += currNum;
        }
        traverse(root->left, currNum);
        traverse(root->right, currNum);
    }
};