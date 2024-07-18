/*
 *          
 *          Construct Binary Tree from Inorder and Postorder Traversal
 *
 * 
 *  Leetcode link            :  https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 *  Time Complexity          : O(n) where n is the number of nodes
 *  Space Complexity         : O(n) includes the map and the recursion stack
 *  Did this run on leetcode : Yes
 *  Approach                 : Construct the tree starting with the root from the last 
 *                             postorder element, finding its position in inorder, and 
 *                             recursively building the right subtree before the left, 
 *                             managing the postorder index decrementally.
 * 
 * 
 */
 // Example : inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 
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
    unordered_map<int, int> map; // Keep a track of nodes to index
    int index; // Will keep a track of the index to get the next root value from post order list

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        index = postorder.size() - 1;
        int end = index;
        int start = 0;

        for(int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return traverse(postorder, start, end);
    }

    TreeNode* traverse(vector<int>& postorder, int start, int end) {
        // Base condition
        if (start > end || index < 0) return NULL;

        // Logic
        int value = postorder[index];
        TreeNode* root = new TreeNode(value);
        index--;
        int rootIdx = map[value];

        root->right = traverse(postorder, rootIdx+1, end);
        root->left = traverse(postorder, start, rootIdx - 1);

        return root;
    }
};