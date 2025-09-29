// Problem - Sum root to leaf ii
//  Time Complexity : O(n)
//  Space Complexity : O(n) where n is the height of the tree
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. Here we used void based recursion to accumulate the number where val is
// calculated as num  * 10 + curr_root->val, we recursively explore left and
// right
// 2. When we hit a leaf, where both left and right are null, we add it to our
// main result
// 3. In the end we return the result, we can do inorder, postorder and preorder
// traversals here

#include <bits/stdc++.h>
using namespace std;

/**
 * Definition for a binary tree node.
 */

struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right)
      : val(x), left(left), right(right) {}
};

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left),
 * right(right) {}
 * };
 */
class Solution {
public:
  int result = 0;
  int sumNumbers(TreeNode *root) {
    helper(root, 0);
    return result;
  }

  void helper(TreeNode *root, int num) {
    if (!root)
      return;
    int val = num * 10 + root->val;
    if (root->left == nullptr && root->right == nullptr) {
      result += val;
    }
    helper(root->left, val);
    helper(root->right, val);
  }
};
