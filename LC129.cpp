// Time Complexity: O(n)
// Space Complexity: O(h)

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        return helper(root, 0);
    }

private:
    int helper(TreeNode* node, int currentSum) {
        if (!node) return 0;

        currentSum = currentSum * 10 + node->val;

        if (!node->left && !node->right) {
            return currentSum;
        }

        int leftSum = helper(node->left, currentSum);
        int rightSum = helper(node->right, currentSum);

        return leftSum + rightSum;
    }
};
