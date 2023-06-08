// TC:O(N)
// SC:O(H)

// Approach:
// Here using post oreder traversal,
// can be solved any traversal we are following for each node we are passing sum

class Solution {
public:
int T_sum=0;
    int sumNumbers(TreeNode* root) {
         
        if(root==nullptr) return 0;
        BST(root,0); 
        return T_sum;    
    }

     void BST(TreeNode* root,int sum)
     {
         if(root==nullptr) return;

        BST(root->left,sum * 10 + root->val);
        BST(root->right,sum * 10 + root->val);
         if(root->left == nullptr && root->right== nullptr)
         {
             sum=sum*10+root->val;
             T_sum+=sum;
             return;
         }

        
      
     }
};