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
// idea - recursive soln  ->preorder - could be done with inorder, preorder, postorder
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        
        int currsum =0 ;
        int result =0;
        helper( root , currsum, result);
        return result;
    }
    
    void helper( TreeNode* root, int currsum, int &result){
        
        // check if root is null
        if(root == NULL){
            return ;
        }
        
        //check for leaf
        if(root->left == NULL && root->right ==NULL){
            
            result += currsum*10 + root->val;
        }
        
        currsum = currsum * 10 + root->val;
        helper(root->left, currsum,  result);
        helper(root->right, currsum, result);
        
    }
};


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

//idea - iterative ->using own stack
class Solution {
public:
    int sumNumbers(TreeNode* root) {
        
        if(root==NULL){
            return 0;
        }
        
        stack<pair<TreeNode*, int>> s1;
        pair<TreeNode* , int > p1;
        int result=0 , currsum =0;
        
        while( root!= NULL || !s1.empty()){
            
            while(root!= NULL){
              
                currsum = currsum* 10 + root->val;
                p1.first  =  root;
                p1.second= currsum;
                
                s1.push(p1);
                root= root->left;
            }
            
           p1 = s1.top();
           s1.pop();
            
           root= p1.first;
           currsum = p1.second;
            
           if(root->left ==NULL && root->right ==NULL){
               result += currsum;
           } 
            
           root= root->right; 
        }
       return result; 
    }
};