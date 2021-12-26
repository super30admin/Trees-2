//Time complexity : O(n)
//Space complexity : O(h)

//Approach :
            // Use any traversal method
            // At each node, create a sum with previous node's value * 10
            // If it is a leaf node then add the value of sum to total sum and return the value of total sum after completing the traversal

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
    int sumNumbers(TreeNode* root) {
        if(root == nullptr)
            return 0;
        
        int totalSum = 0;
        calculate(root, 0 , &totalSum);
        return totalSum;
    }
    
    void calculate(TreeNode* root, int sum, int *totalSum)
    {
        if(root == nullptr)
            return;
        
        if(root->left == nullptr && root->right == nullptr)
        {
            *totalSum += sum * 10 + root->val;
            return;
        }
        
        calculate(root->right, sum * 10 + root->val, totalSum);
        calculate(root->left, sum* 10 + root->val, totalSum);
    }
};