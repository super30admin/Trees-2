//Time Complexity - O(n)
//Space Complexity - O(Height of the tree)
// Problem successfully executed on leetcode
//No problems faced while coading this


#include<iostream>
using namespace std;


  struct TreeNode {
      int val;
      TreeNode *left;
      TreeNode *right;
      TreeNode() : val(0), left(nullptr), right(nullptr) {}
      TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
      TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
  };

class Solution {
public:
    int sum=0;
    int sumNumbers(TreeNode* root) {
        FindSum(root,0);
        return sum;
    }
    
    
    void FindSum(TreeNode* root,int currentSum)
    {
        //base
        if(root== NULL)
        {
            return;
        }
        
        //logic
        currentSum=currentSum*10+root->val;
        if(root->left==NULL && root->right==NULL)
        {
            sum=sum+currentSum;
        }
        FindSum(root->left,currentSum);
        FindSum(root->right,currentSum);
    }
};