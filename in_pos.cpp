// Time Complexity: O(N)
//Space Complexity: O(N)

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
        reverse(postorder.begin(),postorder.end());
        int p = 0;
        return buildTreeHelper(inorder,postorder,0,inorder.size()-1,p);
        
        
    }
public:
    TreeNode* buildTreeHelper(vector<int>& inorder, vector<int>& postorder,int is,int ie,int &postorder_it){
        if(is>ie)return NULL;
        TreeNode* temp = new TreeNode(postorder[postorder_it++]);
        if(is == ie)return temp;
        int pos;
        for(int i = is; i < ie; i++){
            if(inorder[i] == temp->val){
                pos = i;
                break;
            }
        }
        temp->right = buildTreeHelper(inorder,postorder,pos+1,ie,postorder_it);
        temp->left = buildTreeHelper(inorder,postorder,is,pos-1,postorder_it);


        return temp;
    }
};