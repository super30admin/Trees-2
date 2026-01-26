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
    unordered_map<int, int> um;
    int postIndex;
    TreeNode* helper(vector<int>& postorder, int left, int right) {
        if (left > right) {
            return nullptr;
        }

        TreeNode *root = new TreeNode(postorder[postIndex]);
        postIndex--;

        int rootIndex = um[root->val];

        root->right = helper(postorder, rootIndex+1, right);
        root->left = helper(postorder, left, rootIndex-1);

        return root;
    }

    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        for (int i=0;i<inorder.size();i++){
            um[inorder[i]]=i;
        }
        this->postIndex = inorder.size()-1;

        int left = 0;
        int right = inorder.size()-1;
        return helper(postorder, left, right);
    }
};
