// Time Complexity : O(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// we use map to store indices of inorder array.
// postorder is used for creating each node from last and inorder is used for linking left and right subtrees.



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
    int pidx = 0;
    unordered_map<int,int>mp;
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        if(postorder.empty() || postorder.size()==0 || inorder.size()==0){
            return NULL;
        }
        pidx = postorder.size()-1;
        for(int i = 0;i<inorder.size();i++)
        {
            mp.insert({inorder[i],i});
        }
        return f(postorder,0,inorder.size()-1); 
    }
    TreeNode* f(vector<int> & postorder, int lo,int hi)
    {
        if(lo>hi) return NULL;
        int rootval = postorder[pidx--];
        TreeNode* root = new TreeNode(rootval);
        int id = mp[rootval];
        
        root->right = f(postorder,id+1,hi);
        root->left = f(postorder, lo,id-1);
        return root;
    }
};