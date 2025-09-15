// Time Complexity : O(n)
// Space Complexity : O(h)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// Maintain a current variable, which will construct the number formed along the path we are exploring currently
// Once we hit a leaf node, add the updated current number to a global result variable, which will be responsible for aggregating all the path sums
// This can be done in preorder, postorder and inorder as well

class Solution {
private:
    void helper(TreeNode* root, int current, int& result) {
        // base case:
        if(!root) {
            return;
        }
        // logic:
        current = current*10 + root->val;
        if(!root->left && !root->right) {
            result = result + current;
        }
        helper(root->left, current, result);
        helper(root->right, current, result);
    }
public:
    int sumNumbers(TreeNode* root) {
        int result = 0;
        helper(root, 0, result);

        return result;
    }
};