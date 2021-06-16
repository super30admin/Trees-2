//O(n) + O(h)

//local val concept
class Solution {
public:
    int cal(TreeNode* root, int val){
        if(!root) return 0;
        
        val = val*10 + root->val;
        if(root->left==NULL&&root->right==NULL) return val;
        
        return cal(root->left, val) + cal(root->right,val);
    }
    int sumNumbers(TreeNode* root) {
     return cal(root,0);   
    }
};
