class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int, int> mp; 
        for (int i = 0; i < inorder.size(); ++i) mp[inorder[i]] = i; 
        
        stack<TreeNode*> stk; 
        TreeNode *root = nullptr, *node = nullptr; 
        for (int i = postorder.size()-1; i >= 0; --i) {
            int x = postorder[i]; 
            if (!root) root = node = new TreeNode(x); 
            else if (mp[node->val] < mp[x]) {
                stk.push(node); 
                node = node->right = new TreeNode(x); 
            } else {
                while (stk.size() && mp[x] < mp[stk.top()->val]) node = stk.top(), stk.pop(); 
                node = node->left = new TreeNode(x); 
            }
        }
        return root;
    }
};
