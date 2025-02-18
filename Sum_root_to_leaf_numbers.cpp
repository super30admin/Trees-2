// Time Complexity: O(n)
// Space Complexity: O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : Yes

// Approach:
// 1. Do a DFS traversal of the tree and keep track of the current sum.
// 2. If the current node is a leaf node, return the current sum.
// 3. Otherwise, recursively call the left and right subtree with the updated current sum.

class Solution {
    private: 
        int helper(TreeNode* root, int curSum){
            // base case
            if(root == nullptr){
                return 0;
            }
            curSum = curSum * 10 + root -> val; 
            if(root -> left == nullptr && root -> right == nullptr){
                return curSum;
            }
            return helper(root -> left, curSum) + helper(root -> right, curSum);
        }
    public:
        int sumNumbers(TreeNode* root) {
            return helper(root, 0);
        }
    };