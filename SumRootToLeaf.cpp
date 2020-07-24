
//Recursion Method
// Time Complexity : O(N) where N=Number of anagrams each having length K
// Space Complexity : O(H)
//Iterative Method
// Time Complexity : O(N) where N=Number of anagrams each having length K
// Space Complexity : O(H)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    double sum =0;
    int sumNumbers(TreeNode* root) {
        if(root == NULL){
            return 0;
        }
        stack<pair<TreeNode*,double>> stack;
        double tempsum = 0,sum=0;
        while(root!=NULL || !stack.empty()){
            while(root!=NULL){
                tempsum = tempsum*10 + root->val;  
                stack.push(make_pair(root,tempsum));
                root = root->left;
            }
            root = stack.top().first;
            tempsum = stack.top().second;
            if(root->left==NULL && root->right==NULL){
                sum = sum + stack.top().second;
            }
                stack.pop();
                root = root->right;
            
        }
        return sum;
        //return inorder(root,0);
            
            
        }
    
    double inorder(TreeNode* root,double tempsum){
            //base
            if(root==NULL){
                return 0;
            }
          if(root->left==NULL && root->right==NULL){
                return tempsum*10 + root->val;
            }
            //tempsum = tempsum*10 + root->val;
            return(inorder(root->left,tempsum*10 + root->val)+ inorder(root->right,tempsum*10 + root->val));
          
            }
};
