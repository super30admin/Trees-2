// time: O(n)
// space: O(n)

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
    int idx;
    unordered_map<int,int> umap;
    TreeNode* helper(int in1, int in2, vector<int>& postorder) {
        
        if(in1 > in2) {
            return NULL;
        }
        
        TreeNode* node = new TreeNode(postorder[idx]);
        
        int root = umap[postorder[idx]];
        idx--;
        node -> right = helper(root+1, in2, postorder);
        node -> left = helper(in1, root-1, postorder);
        
        
        
        return node;
    }
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.size() == 0) {
            return NULL;
        }
        for(int i = 0; i < inorder.size(); i++) {
            umap[inorder[i]] = i;
        }
        idx = postorder.size()-1;
        
        return helper(0, inorder.size()-1, postorder);
    }
};