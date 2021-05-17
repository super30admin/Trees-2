// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    TreeNode* helper(int &postEnd,int inStart,int inEnd,vector<int>& postorder,vector<int>& inorder,unordered_map<int,int>&mp){
        if(inStart > inEnd ) return nullptr;
        TreeNode *root = new TreeNode(postorder[postEnd]);
        int inIndex= mp[postorder[postEnd]];
        postEnd--;
        root->right =helper(postEnd,inIndex+1,inEnd,postorder,inorder,mp);
        root->left =helper(postEnd,inStart,inIndex-1,postorder,inorder,mp);
        return root;
    }
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        unordered_map<int,int>mp;
        for(int i=0;i<inorder.size();i++){
            mp[inorder[i]] = i;
        }
        int l =postorder.size()-1;
        return helper(l,0,inorder.size()-1,postorder,inorder,mp);
    }
    
};