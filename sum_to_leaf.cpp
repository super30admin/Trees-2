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

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach
//Recursive solution
// Time Complexity : O(n)
// Space Complexity : O(h) worst case O(n).
//1. Find root and traverse complete left or rigt root through recursion
//2. Return the left root child sum when both of its child are NULL.
//3. Return the right root child sum when both of its child are NULL.


class Solution {
public:
    int cummulative_sum=0;
    int sumNumbers(TreeNode* root) {
        //edge case
        if(root == NULL){
            return 0;
        }
        calculate_sum(root, 0);
        return cummulative_sum;
    }
    
    void calculate_sum(TreeNode*  root, int sum_till_node){
        //returning condition
        if(root == NULL){
            return;
        }
        sum_till_node = (sum_till_node *10)+root->val;
        if(root->left == NULL && root->right == NULL ){
            cummulative_sum += sum_till_node;
        }
        calculate_sum(root->left, sum_till_node);
        calculate_sum(root->right, sum_till_node);
    }
};
