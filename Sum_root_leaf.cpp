// Time Complexity : O(N) , N is number of Nodes of tree
// Space complexity : O(H) , H is height of the tree

class Solution {
public:
    int sumNumbers(TreeNode* root) {
          return  dfs(root , 0);    
    }

    int dfs(TreeNode* root,int num){
        if (root == NULL){
            return 0 ; 
        }

        if(root -> left == NULL && root -> right == NULL){
            return num*10 + root->val ; 
        }

        int case_1 = dfs(root->left , num*10 + root->val);
        int case_2 = dfs(root->right , num*10 + root->val) ; 

        return case_1 + case_2 ; 
    }
};
