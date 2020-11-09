// Time complexity is O(n) - n is the number of nodes
// Space complexity is O(h) - h is the height of the tree. In worst case(skewed tree) h = n.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


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
    int helper(TreeNode* root, int currSum) {
        //base case
        if(root == nullptr) return 0;
        if(root->left == nullptr && root->right == nullptr) {
            return currSum*10 + root->val;
        }
        
        //logic
        int leftSum = helper(root->left, currSum*10 + root->val);
        int rightSum = helper(root->right, currSum*10 + root->val);
        return  leftSum+rightSum;
    }
    
    int sumNumbers(TreeNode* root) {
        if(root == nullptr) return 0;
        return helper(root, 0);
    }
};
