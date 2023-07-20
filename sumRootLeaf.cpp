// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :

/*
perform void based recursion and update the local variable after entering each call until it leaches the leaf node
and when it reaches the leaf node update the result for each branch

*/


// Your code here along with comments explaining your approach
#include <iostream>
#include <vector>



class Solution {
public:
    int result=0;
    int sumNumbers(TreeNode* root){

        helper(root,0);
        return result;

    }


        

    void helper(TreeNode* root,int sum){

        if(root==nullptr){
            return;
        }

        sum=sum*10+root->val;
        
        helper(root->left,sum);
        
        helper(root->right,sum);

        if(root->left == nullptr && root->right==nullptr){
            result+=sum;
        }

    }
};