/*
Traverse the binary tree in a preorder fashion, maintaining the current number formed from the root to the current node.
When reaching a leaf node, add the current number to the total sum.
Return the sum of all root-to-leaf numbers.
Time Complexity: O(N), where N is the number of nodes in the binary tree. Each node is visited once.
Space Complexity: O(H), where H is the height of the binary tree. The space complexity is determined by the recursive call stack, which is at most the height of the tree for a balanced tree.*/
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
int rootToLeaf = 0;
    int sumNumbers(TreeNode* root) {
        preorder(root, 0);
    return rootToLeaf;
    }
 public:
  void preorder(TreeNode* r, int currNumber) {
    if (r != NULL) {
      currNumber = currNumber * 10 + r->val;
      if (!r->left&& !r->right) {
        rootToLeaf += currNumber;
      }
      preorder(r->left, currNumber);
      preorder(r->right, currNumber) ;
    }
  }
};