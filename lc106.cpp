
// Time Complexity: O(n)
// Space Complexity: O(n)

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
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> inorder_index_map;
        int n = inorder.size();

        for (int i = 0; i < n; ++i) {
            inorder_index_map[inorder[i]] = i;
        }

        int post_index = n - 1;
        return buildTree(inorder, postorder, inorder_index_map, 0, n - 1, post_index);
    }

private:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder,
                            unordered_map<int, int>& inorder_index_map,
                            int in_start, int in_end, int& post_index) {
        if (in_start > in_end) return nullptr;

        int root_val = postorder[post_index--];
        TreeNode* root = new TreeNode(root_val);

        int root_index = inorder_index_map[root_val];

        root->right = buildTree(inorder, postorder, inorder_index_map, root_index + 1, in_end, post_index);
        root->left = buildTree(inorder, postorder, inorder_index_map, in_start, root_index - 1, post_index);

        return root;
    }
};
