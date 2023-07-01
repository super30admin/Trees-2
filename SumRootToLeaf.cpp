// Time Complexity: O(n)
// Space Complexity: Height of the tree

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
    int result = 0; 
    int sumNumbers(TreeNode* root) {

        sumRootToLeaf(root, 0);
        return result; 
    }

    void sumRootToLeaf(TreeNode* node, int number) {
        number = number*10 + node->val; 
        if(node->left == nullptr && node->right == nullptr) {
            result += number; 
            return; 
        } else {
            if(node->left != nullptr) sumRootToLeaf(node->left, number);
            if(node->right != nullptr) sumRootToLeaf(node->right, number); 
        }
    }
};