// TC = O(N)
// SC = O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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
    // TC = O(N)
    // SC = O(N)
    unordered_map<int, int> map;
    int index = 0;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        // null 
        if(inorder.size() == 0 || postorder.size() == 0) return nullptr;
        index = inorder.size() - 1;
        for(int i = 0; i < inorder.size(); i++) map[inorder[i]] = i;
        return helper(postorder, 0, inorder.size() - 1);
    }
    TreeNode* helper(vector<int>& postorder, int start, int end) {
        // base
        if(start > end) return nullptr;
        // logic
        int rootVal = postorder[index];
        index--;
        int rootIndex = map[rootVal];
        TreeNode* root = new TreeNode(rootVal);
        // important to build right tree first then left
        root->right = helper(postorder, rootIndex + 1, end);
        root->left = helper(postorder, start, rootIndex - 1);
        return root;
    }
};