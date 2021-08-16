// Time Complexity : O(N) where N is the number of nodes in the tree
// Space Complexity : O(H) where H is the height of the tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nope
// Problem Link: https://leetcode.com/problems/sum-root-to-leaf-numbers/
// Submission Link: https://leetcode.com/submissions/detail/537111630/

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        int sum = 0;
        return helper(root, 0, sum);
    }
    
    int helper(TreeNode* root, int cur, int& sum){
        if(root == NULL)
            return sum;
        
        if(root -> left == NULL && root -> right == NULL){
            sum += (cur * 10 + root -> val);
            return sum;
        }
        
        helper(root -> left, cur * 10 + root -> val, sum);
        helper(root -> right, cur * 10 + root -> val, sum);
        
        return sum;
    }
};