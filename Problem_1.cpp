/*
 ? Problem: Construct binary tree from inorder and post order traversal
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
*/

#include <vector>
#include <unordered_map>


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

class Solution {
    int post_idx;
    std::unordered_map<int, int> idx_map;
    std::vector<int> inorder;
    std::vector<int> postorder;

    TreeNode* helper(int in_left, int in_right) {
        if (in_left > in_right)
            return nullptr;

        // action
        int root_val = postorder[post_idx];
        TreeNode* root = new TreeNode(root_val);

        int index = idx_map[root_val];

        // recursion
        post_idx--;
        root->right = helper(index + 1, in_right);
        root->left = helper(in_left, index - 1);

        return root;
    }
public:
    TreeNode* buildTree(std::vector<int>& inorder, std::vector<int>& postorder) {
        this->inorder = inorder;
        this->postorder = postorder;
        post_idx = postorder.size() - 1;

        int idx = 0;
        for (int val : inorder) {
            idx_map[val] = idx++;
        }

        return helper(0, inorder.size() - 1);
    }
};
