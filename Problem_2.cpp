//Time Complexity: O(N), where n is the elements in the tree.
//Space Complexity: O(h), height of the tree.

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
    int sum = 0;
private:
    void helper(TreeNode* root, int current){
        current = current * 10 + root->val;
        if(root->left ==NULL && root->right==NULL){
            sum += current;
            return ;
        }
        else{
            if(root->left!=NULL)  helper(root->left,current);
            if(root->right!=NULL) helper(root->right,current);
        }
    }
public:
    int sumNumbers(TreeNode* root) {
        if(root!=NULL) helper(root,0);
        return sum;
    }
};