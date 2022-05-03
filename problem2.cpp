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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size() == 0)  return NULL;
        
        TreeNode *root = new TreeNode(preorder[0]);
        int idx = 0;
        for(int i =0;i<inorder.size();i++) {
            if(inorder[i] == preorder[0]){
                idx = i;
                break;
            }
        }
        
        vector<int>leftOrder(inorder.begin(), inorder.begin() + idx);
        vector<int>rightOrder(inorder.begin() +idx+1, inorder.end());
        
        vector<int>leftPreOrder(preorder.begin() + 1, preorder.begin() + idx +1);
        vector<int>rightPreOrder(preorder.begin()+idx+1, preorder.end());
                          
        root->left =  buildTree(leftPreOrder,leftOrder);
        root->right =  buildTree(rightPreOrder,rightOrder);
                          
         return root;
        
        
    }
};