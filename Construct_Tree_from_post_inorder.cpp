// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning

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
        //base case
        if(inorder.size()==0 || postorder.size()==0) return NULL;
        
        return helper(inorder, postorder, 0, inorder.size()-1, postorder.size()-1);
    }
    
    TreeNode* helper(vector<int>&  inorder,vector<int>&  postorder, int in_start,int in_end,int post_index){
        //returning condition
        if(in_start > in_end) return NULL;
        TreeNode* root = new TreeNode(postorder[post_index]);
        int index;
        for( index =0; index< inorder.size(); index++){
            if(inorder[index] == root->val) break;
        }
        root->right = helper(inorder, postorder, index+1, in_end, post_index-1);
        root->left  = helper(inorder, postorder, in_start, index-1, post_index-in_end+index-1);
        return root;
    }
    
};