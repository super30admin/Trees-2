// Problem - Given postorder and inorder traversal of a tree, construct the
// binary tree.
//  Time Complexity : O(n)
//  Space Complexity : O(n)
//  Did this code successfully run on Leetcode : Yes
//  Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// 1. We take the same approach as we did for inorder and preorder traversal
// 2. Maintain a global idx which picks the next root  from postorder
// 3. Here, we first go right and then go left since postorder is Left Right
// Root

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
  int idx;
  unordered_map<int, int> u;
  TreeNode *buildTree(vector<int> &inorder, vector<int> &postorder) {
    idx = (int)inorder.size() - 1;
    for (int i = 0; i < inorder.size(); i++) {
      u[inorder[i]] = i;
    }
    return helper(postorder, 0, (int)inorder.size() - 1);
  }

  TreeNode *helper(vector<int> &postorder, int start, int end) {
    if (start > end) {
      return nullptr;
    }
    int rootval = postorder[idx];
    int inorderidx = u[rootval];
    idx--;
    TreeNode *node = new TreeNode(rootval);
    node->right = helper(postorder, inorderidx + 1, end);
    node->left = helper(postorder, start, inorderidx - 1);
    return node;
  }
};
