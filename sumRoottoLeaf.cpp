// Time Complexity :O(n) where n in the number of nodes in a tree
// Space Complexity : O(H)  where H is the Height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

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
    //int currSum = 0;
    //int res;
public:
    int sumNumbers(TreeNode* root) {
        return helper(root,0);
    }
    int helper(TreeNode* root, int currSum){
        //base case
        if(!root) return 0;
        //logic case 
        currSum = currSum*10 + root->val;
        if(root->right == nullptr && root->left == nullptr){
            return currSum;
            //return res;
        }
        return helper(root->left,currSum) + helper(root->right,currSum);
    }
};