//Time Complexity: O(N), where n is the elements in the tree.
//Space Complexity: O(N).

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
    unordered_map<int,int> in_map;
    int pre_idx = 0;
private:
     TreeNode* helper(vector<int>& preorder, vector<int>& inorder, int in_left, int in_right){
            if(in_left > in_right){
                return NULL;
            }
            int root_val = preorder[pre_idx];
            TreeNode* root = new TreeNode(root_val);
            int in_Idx = in_map[root_val];
            pre_idx++;
            root->left = helper(preorder, inorder, in_left, in_Idx-1);
            root->right = helper(preorder, inorder, in_Idx+1, in_right);
            return root;
    }
    

public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
            
        for(int i=0; i<inorder.size(); i++){
            in_map.emplace(inorder.at(i), i);
        }
        return helper(preorder, inorder, 0, inorder.size()-1); 
    }
   
};