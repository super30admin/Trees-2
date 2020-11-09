// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(n) - Hashmap is used
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    unordered_map<int, int> map;
    int index;
    TreeNode* helper(vector<int>& inorder, vector<int>& postorder, int start, int end) {
        //base condition
        if(start > end) return nullptr;
        
        // logic
        int rootValue = postorder[index];
        index--;
        int rootIndex = map[rootValue]; // root Index in Inorder traversal
        TreeNode *root = new TreeNode(rootValue);
        root->right = helper(inorder, postorder, rootIndex+1, end);
        root->left = helper(inorder, postorder, start, rootIndex-1);
        
        return root;
    }
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(inorder.size() == 0 || postorder.size() == 0) return nullptr;
        index = postorder.size()-1;
        for(int i = 0; i < inorder.size(); i++) {
            map[inorder[i]] = i;
        }
        return helper(inorder, postorder, 0, inorder.size()-1);
    }
    
};
