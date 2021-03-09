//TC: O(n) where n is number of tree nodes
//SC: O(n) 

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
        
        int rootPosition = postorder.size() - 1;
        TreeNode *root = helper(inorder, 0, inorder.size()-1, postorder, rootPosition);  //parameters passed can include left index for inorder, right index for inorder, the lists themselves, and the root position
        
        return root;
        
    }
    
    TreeNode *helper(vector<int>& inorder, int l, int r, vector<int>& postorder, int &rootPosition){
        
        if(l > r || rootPosition < 0)
            return NULL;
        
        int rootVal = postorder[rootPosition];
        
        int rootindex = find(inorder.begin()+l, inorder.begin()+r, rootVal) - inorder.begin();
        
        TreeNode *root = new TreeNode(rootVal);
        
        //pointer, so this value decreases with every recursion
        rootPosition--;
        
        //creates the entire right subtree first and then creates the left subtree
        root->right = helper(inorder, rootindex+1, r, postorder, rootPosition);
        root->left = helper(inorder, l, rootindex-1, postorder, rootPosition);
        
        return root;        
        
    }
};