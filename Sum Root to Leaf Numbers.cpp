//Time Complexity- O(n)
//Space Complexity- O(h) (Recursive Stack)

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        
        if(root==NULL){
            return 0;
        }
        
        int sum=0;
        dfs(root,sum,0);
        return sum;
    }
    
    void dfs(TreeNode* root,int &sum,int currsum){
        currsum=currsum*10+root->val;
        if(root->left==NULL && root->right==NULL){
            sum+=currsum;
            return;
        }
        
        if(root->left){
            dfs(root->left,sum,currsum);
        }
        if(root->right){
            dfs(root->right,sum,currsum);
        }
    }
};