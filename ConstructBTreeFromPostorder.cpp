// Time Complexity : O(n)
// Space Complexity : O(n) where n tends to h
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Maintain the pointer to point to root value of current subtree.
 * Last value in postorder is the root value of tree. 
 * Create a node using that value and decrement the pointer to point to next subtree root value. 
 * Find the root value index in the inorder array.
 * Split the inorder array in two parts - (root_index_in_inorder + 1, n) and (0, root_index_in_inorder - 1 ).
 * Keep repeating the above steps until start and end indexes do not cross each other which indicates end of subtree.   
 */

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
    map<int, int> m;
    int idx;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if (inorder.size() == 0 || postorder.size() == 0)
            return nullptr;
        
        idx = postorder.size() - 1;
        
        for (int i = 0; i < inorder.size(); i++)
        {
            m.insert({inorder[i], i});
        }
        return helper(postorder, 0, postorder.size() - 1);
    }
    
    TreeNode* helper(vector<int>& postorder, int start, int end)
    {
        if (start > end)
            return nullptr;
        
        TreeNode* root = new TreeNode(postorder[idx]);
        int index = m.find(postorder[idx])->second;
        idx--;
        
        root->right = helper(postorder, index + 1, end);
        root->left = helper(postorder, start, index - 1);
        
        return root;
    }
};