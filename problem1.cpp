
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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
/*
class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        
    }
};
*/
class Solution {
public:
    
    TreeNode* buildTreeRecur(  vector<int>& postorder, vector<int>& inorder, int leftidx, int rightidx,
                               int &preidx, unordered_map<int,int> & inordermap ){
        if( leftidx > rightidx){
            return nullptr;
        }
        
        TreeNode* root = new TreeNode( postorder[preidx] );
        preidx--;
        int inindex = inordermap[root->val];
        
        root->right = buildTreeRecur( postorder, inorder, inindex+1, rightidx, preidx, inordermap  );
        root->left = buildTreeRecur( postorder, inorder, leftidx, inindex-1, preidx, inordermap );
        
            
        return root;    
        
    }
    
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder ) {
        unordered_map<int,int>inordermap;  // value -> index
        for( int i=0; i<inorder.size(); i++){
            inordermap[inorder[i]] = i;
        }
        
        int preidx = postorder.size()-1;
        int leftidx = 0;
        int rightidx = inorder.size()-1;
        return buildTreeRecur( postorder, inorder, leftidx, rightidx, preidx, inordermap );
        
    }
};
