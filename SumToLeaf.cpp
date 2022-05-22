//TC = O(N)
//SC = O(H)

class Solution {
public:
    int sum=0;
    int sumNumbers(TreeNode* root) {
        helper(root,0);
        return sum;
    }
    
    void helper(TreeNode* root, int num){
        //base
        if(root==NULL) return;
        if(root->left==NULL && root->right==NULL){
            sum += num*10 + root->val;
        }
        //logic
        helper(root->left, num*10+root->val);
        helper(root->right,num*10+root->val);
        
    }
};


//Iterative
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        stack<TreeNode*> s1;
        stack<int> s2;
        int curSum=0;
        int sum =0;
        while(root!=NULL || !s1.empty()){
            while(root!=NULL){
                curSum = curSum*10+root->val;
                s1.push(root);
                s2.push(curSum);
                root = root->left;
            }
            root = s1.top();   s1.pop();
            curSum = s2.top(); s2.pop();
            if(root->left==NULL && root->right==NULL){
                sum += curSum;
            }
            root = root->right;
        }
        return sum;
    }
};
