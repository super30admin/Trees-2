/*
Time Complexity: O(n) (n-all elements in a tree)
Space Complexity: O(h)(h-height of the tree)
Did this code successfully run on Leetcode :yes
Any problem you faced while coding this : no
*/
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
        stack<pair<TreeNode*,int>> stck;
        int ans;
        stck.push(pair(root,0));
        while(!stck.empty()){
            pair temp = stck.top();
            stck.pop();
            TreeNode* node = temp.first;
            int pNum = temp.second;
            pNum = pNum*10 + node->val;
            if(node->left==NULL && node->right==NULL){
                ans+=pNum;
            } else{
                if(node->right!=NULL){
                    stck.push(pair(node->right,pNum));
                }
                if(node->left!=NULL){
                    stck.push(pair(node->left,pNum));
                }
            }
        }
        return ans;
    }
    
};