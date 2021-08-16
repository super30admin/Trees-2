// Time Complexity : O(N) where N is the number of nodes in the tree
// Space Complexity : O(N) where N is the number of nodes in the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
// Submission Link: https://leetcode.com/submissions/detail/538106302/

class Solution {
    int idx;
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        idx = postorder.size() - 1;
        
        unordered_map<int, int> index;
        
        for(int i = 0; i < inorder.size(); i++)
            index[inorder[i]] = i;
        
        return helper(index, postorder, 0, postorder.size() - 1);
    }
    
    TreeNode* helper(unordered_map<int, int>& index, vector<int>& postorder, int low, int high){  
        if(low > high)
            return NULL;
        
        int val = postorder[idx--];
        TreeNode* root = new TreeNode(val);
        root -> right = helper(index, postorder, index[val] + 1, high);
        root -> left = helper(index, postorder, low, index[val] - 1);
        
        return root;
    }
};