// Time Complexity : O(n)
// Space Complexity :  O(1)
// Did this code successfully run on Leetcode : NO
// Any problem you faced while coding this: Tried using the Approach from Previous Similar Question.
// But not yet working. Will work on it and submit again

class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.size() == 0)
            return NULL;
        
        int root_val = postorder[postorder.size()-1];
        int root_index = postorder.size()-1;
        TreeNode* root = new TreeNode;
        root->val = root_val;
        
        for(int i = 0; i < inorder.size(); i++)
        {
            if(inorder[i] == root->val)
                root_index = i;
        }
        
        vector<int> post_left;
        vector<int> post_right;
        vector<int> in_left;
        vector<int> in_right;
        
        // Confused about the indices to use for correct operation
        copy(postorder.end()-root_index, postorder.end()-1, back_inserter(post_left));
        copy(postorder.end()-root_index+1, postorder.end()-postorder.size(), back_inserter(post_right));
        copy(inorder.begin(), inorder.begin()+root_index, back_inserter(in_left));
        copy(inorder.begin()+root_index+1, inorder.begin()+inorder.size(), back_inserter(in_right));
        
        root->left = buildTree(post_left, in_left);
        root->right = buildTree(post_right, in_right);
        
        return root;
        
    }
};

